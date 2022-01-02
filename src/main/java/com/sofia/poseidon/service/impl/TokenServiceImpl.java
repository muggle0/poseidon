package com.sofia.poseidon.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.entity.AuthUrlPathDO;
import com.sofia.poseidon.entity.pojo.SysUrlInfo;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.mapper.SysUrlInfoMapper;
import com.sofia.poseidon.mapper.SysUserMapper;
import com.sofia.poseidon.service.SysUrlInfoService;
import com.muggle.poseidon.service.TokenService;
import com.sofia.poseidon.helper.LoginHelper;
import com.sofia.poseidon.manager.UserInfoManager;
import com.sofia.poseidon.tool.MyDistributedLocker;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@Service
public class TokenServiceImpl implements TokenService {
    private static final Logger log = LoggerFactory.getLogger(TokenServiceImpl.class);
    public static final String URL_SYNC_LOCK = "poseidon:flyway:processUrl:count";
    @Autowired
    private UserInfoManager userInfoManager;
    @Autowired
    private SysUrlInfoMapper urlInfoMapper;
    @Autowired
    private Map<String, LoginHelper> loginHelperMap;

    private RedissonClient redissonClient;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    SysUrlInfoService oaUrlInfoService;

    @Autowired
    public TokenServiceImpl(RedissonClient redissonClient) {
        this.redissonClient=redissonClient;
        redissonClient.getCountDownLatch(URL_SYNC_LOCK).trySetCount(1);
    }

    @Override
    public UserDetails getUserById(Long userId) {
        final SysUserMapper userMapper = userInfoManager.getUserMapper();
        final SysUser sysUser = userMapper.selectById(userId);
        final String promissionCodes = userInfoManager.getPermissionByUserId(sysUser.getId());
        sysUser.setRoleCodes(promissionCodes);
        return null;
    }

    /**
     *
     * @param roles
     * @param url
     * @return
     */
    @Override
    public boolean rooleMatch(Collection<? extends GrantedAuthority> roles, String url) {
        // todo
        return true;
    }

    @Override
    public void processUrl(List<AuthUrlPathDO> list) {
        try {
            redissonClient.getCountDownLatch(URL_SYNC_LOCK).await(3, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return;
        }
        Set<String> urlSet = new HashSet<>();
        Iterator<AuthUrlPathDO> iterator = list.iterator();
        while (iterator.hasNext()) {
            AuthUrlPathDO next = iterator.next();
            if (next.getMethodURL().contains("error") || next.getMethodURL().contains("swagger") || next.getClassUrl() == null) {
                iterator.remove();
                continue;
            }

            String url = next.getMethodURL();
            urlSet.add(next.getClassUrl());
            urlSet.add(url);
        }
        QueryWrapper<SysUrlInfo> urlInfoQuery = new QueryWrapper<>();
        urlInfoQuery.in("url", urlSet);
        List<SysUrlInfo> sysUrlInfos = urlInfoMapper.selectList(urlInfoQuery);
        Map<String, SysUrlInfo> urlMap = sysUrlInfos.stream().collect(Collectors.toMap(SysUrlInfo::getUrl, bean -> bean));
        List<SysUrlInfo> sysUrlInfoList = new ArrayList<>();
        for (AuthUrlPathDO authUrlPathDO : list) {
            String url = authUrlPathDO.getMethodURL();
            SysUrlInfo dbSysUrlInfo = urlMap.get(url);
            if (dbSysUrlInfo != null) {
                continue;
            }
            SysUrlInfo parent = urlMap.get(authUrlPathDO.getClassUrl());
            if (parent == null) {
                SysUrlInfo parentOaurl = new SysUrlInfo();
                parentOaurl.setUrl(authUrlPathDO.getClassUrl());
                parentOaurl.setDescription(authUrlPathDO.getClassDesc());
                parentOaurl.setGmtCreate(new Date());
                parentOaurl.setEnable(true);
                parentOaurl.setRequestType(authUrlPathDO.getRequestType());
                parentOaurl.setClassName(authUrlPathDO.getClassName());
                parentOaurl.setId(IdWorker.getId());
                sysUrlInfoList.add(parentOaurl);
                urlMap.put(authUrlPathDO.getClassUrl(), parentOaurl);
                parent = parentOaurl;
            }
            SysUrlInfo sysUrlInfo = new SysUrlInfo();
            sysUrlInfo.setUrl(url);
            sysUrlInfo.setDescription(authUrlPathDO.getMethodDesc());
            sysUrlInfo.setGmtCreate(new Date());
            sysUrlInfo.setEnable(true);
            sysUrlInfo.setRequestType(authUrlPathDO.getRequestType());
            sysUrlInfo.setClassName(authUrlPathDO.getClassName());
            sysUrlInfo.setMethodName(authUrlPathDO.getMethodName());
            sysUrlInfo.setId(IdWorker.getId());
            sysUrlInfo.setParentId(parent.getId());
            sysUrlInfo.setParentUrl(parent.getUrl());
            sysUrlInfoList.add(sysUrlInfo);
        }
        oaUrlInfoService.saveBatch(sysUrlInfoList);
    }

    @Override
    public UserDetails login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SimplePoseidonCheckException {
        if (!httpServletRequest.getMethod().equals(HttpMethod.POST.name())) {
            throw new SimplePoseidonCheckException("非法请求");
        }
        Object username =null;
        Object password = null;
        Object loginType = null;
        try ( BufferedReader streamReader = new BufferedReader( new InputStreamReader(httpServletRequest.getInputStream(), "UTF-8"))){
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null){
                responseStrBuilder.append(inputStr);
            }
            JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
            username=jsonObject.get("username");
            password=jsonObject.get("password");
            loginType=jsonObject.get("loginType");
        } catch (IOException e) {
            log.error("登录异常",e);
           throw new SimplePoseidonCheckException("数据读取异常");
        }
        if (username == null) {
            throw new SimplePoseidonCheckException("请填写用户名");
        }
        if (password == null) {
            throw new SimplePoseidonCheckException("请填写密码");
        }
        if (loginType == null) {
            throw new SimplePoseidonCheckException("请选择登录类型");
        }
        LoginHelper loginHelper = loginHelperMap.get(loginType.toString().concat("Helper"));
        if (loginHelper == null) {
            throw new SimplePoseidonCheckException("登录类型错误");
        }
        UserDetails login = loginHelper.login(username.toString(), password.toString());
        return login;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userInfoManager.loadUserByUsername(username);
    }
}
