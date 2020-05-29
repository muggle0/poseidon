package com.muggle.poseidon.oa.security;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.entity.AuthUrlPathDO;
import com.muggle.poseidon.entity.oa.OaUrlInfo;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.oa.mapper.OaUrlInfoMapper;
import com.muggle.poseidon.oa.mapper.OaUserInfoMapper;
import com.muggle.poseidon.oa.service.impl.OaUrlInfoServiceImpl;
import com.muggle.poseidon.service.TokenService;
import com.muggle.poseidon.service.oa.IOaUrlInfoService;
import com.muggle.poseidon.util.PoseidonIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/4/16
 **/

@Service
public class OATokenServiceImpl implements TokenService {
    private static final Logger log = LoggerFactory.getLogger(OATokenServiceImpl.class);
    @Autowired
    OaUserInfoMapper userInfoMapper;
    @Autowired
    OaUrlInfoMapper urlInfoMapper;
    @Autowired
    IOaUrlInfoService oaUrlInfoService;

    @Autowired
    PoseidonIdGenerator idGenerator;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails getUserById(Long aLong) {
        return null;
    }

    @Override
    public boolean rooleMatch(Collection<? extends GrantedAuthority> collection, String s) {
        return false;
    }

    @Override
    public void saveUrlInfo(List<AuthUrlPathDO> list) {
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
        QueryWrapper<OaUrlInfo> urlInfoQuery = new QueryWrapper<>();
        urlInfoQuery.in("url", urlSet);
        List<OaUrlInfo> oaUrlInfos = urlInfoMapper.selectList(urlInfoQuery);
        Map<String, OaUrlInfo> urlMap = oaUrlInfos.stream().collect(Collectors.toMap(OaUrlInfo::getUrl, bean -> bean));
        List<OaUrlInfo> oaUrlInfoList = new ArrayList<>();
        for (AuthUrlPathDO authUrlPathDO : list) {
            String url = authUrlPathDO.getMethodURL();
            OaUrlInfo dbOaUrlInfo = urlMap.get(url);
            if (dbOaUrlInfo != null) {
                continue;
            }
            OaUrlInfo parent = urlMap.get(authUrlPathDO.getClassUrl());
            if (parent == null) {
                OaUrlInfo parentOaurl = new OaUrlInfo();
                parentOaurl.setUrl(authUrlPathDO.getClassUrl());
                parentOaurl.setDescription(authUrlPathDO.getClassDesc());
                parentOaurl.setGmtCreate(new Date());
                parentOaurl.setEnable(true);
                parentOaurl.setRequestType(authUrlPathDO.getRequestType());
                parentOaurl.setClassName(authUrlPathDO.getClassName());
                parentOaurl.setId(idGenerator.simpleNextId());
                oaUrlInfoList.add(parentOaurl);
                urlMap.put(authUrlPathDO.getClassUrl(), parentOaurl);
                parent = parentOaurl;
            }
            OaUrlInfo oaUrlInfo = new OaUrlInfo();
            oaUrlInfo.setUrl(url);
            oaUrlInfo.setDescription(authUrlPathDO.getMethodDesc());
            oaUrlInfo.setGmtCreate(new Date());
            oaUrlInfo.setEnable(true);
            oaUrlInfo.setRequestType(authUrlPathDO.getRequestType());
            oaUrlInfo.setClassName(authUrlPathDO.getClassName());
            oaUrlInfo.setMethodName(authUrlPathDO.getMethodName());
            oaUrlInfo.setId(idGenerator.nextId());
            oaUrlInfo.setParentId(parent.getId());
            oaUrlInfo.setParentUrl(parent.getUrl());
            oaUrlInfoList.add(oaUrlInfo);
        }
        oaUrlInfoService.saveBatch(oaUrlInfoList);
    }

    @Override
    public UserDetails login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SimplePoseidonCheckException {
        String method = httpServletRequest.getMethod();
        if (!"POST".equals(method)) {
            throw new SimplePoseidonCheckException("错误的请求方式");
        }
        try {
            BufferedReader reader = httpServletRequest.getReader();
            OaUserInfo oaUserInfo = JSONObject.parseObject(reader.readLine(), OaUserInfo.class);
            reader.close();
            if (StringUtils.isEmpty(oaUserInfo.getUsername())) {
                throw new SimplePoseidonCheckException("请输入用户名");
            } else if (StringUtils.isEmpty(oaUserInfo.getPassword())) {
                throw new SimplePoseidonCheckException("请输入密码");
            }
            OaUserInfo dbUserInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<OaUserInfo>().eq(OaUserInfo::getUsername, oaUserInfo.getUsername()));
            if (dbUserInfo == null) {
                throw new SimplePoseidonCheckException("用户不存在");
            }
            String password = dbUserInfo.getPassword();
            if (!passwordEncoder.matches(oaUserInfo.getPassword(), password)) {
                throw new SimplePoseidonCheckException("密码错误");
            }
            return dbUserInfo;
        } catch (IOException e) {
            log.error("用户登录获取request io 异常", e);
            throw new SimplePoseidonCheckException("登录异常");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userInfoMapper.selectOne(new LambdaQueryWrapper<OaUserInfo>().eq(OaUserInfo::getUsername, username));
    }
}
