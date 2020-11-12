package com.muggle.poseidon.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.entity.AuthUrlPathDO;
import com.muggle.poseidon.entity.OaUrlInfo;
import com.muggle.poseidon.entity.OaUserInfo;
import com.muggle.poseidon.mapper.OaUrlInfoMapper;
import com.muggle.poseidon.service.IOaUrlInfoService;
import com.muggle.poseidon.service.TokenService;
import com.muggle.poseidon.service.helper.LoginHelper;
import com.muggle.poseidon.service.manager.UserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    UserInfoManager userInfoManager;
    @Autowired
    OaUrlInfoMapper urlInfoMapper;
    @Autowired
    Map<String, LoginHelper> loginHelperMap;

    @Autowired
    IOaUrlInfoService oaUrlInfoService;
    @Override
    public UserDetails getUserById(Long userId) {

        return null;
    }

    @Override
    public boolean rooleMatch(Collection<? extends GrantedAuthority> collection, String s) {
        return false;
    }

    @Override
    public void processUrl(List<AuthUrlPathDO> list) {
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
                parentOaurl.setId(IdWorker.getId());
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
            oaUrlInfo.setId(IdWorker.getId());
            oaUrlInfo.setParentId(parent.getId());
            oaUrlInfo.setParentUrl(parent.getUrl());
            oaUrlInfoList.add(oaUrlInfo);
        }
        oaUrlInfoService.saveBatch(oaUrlInfoList);
    }

    @Override
    public UserDetails login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SimplePoseidonCheckException {
        // 登录类型
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String loginType = httpServletRequest.getParameter("loginType");
        LoginHelper loginHelper = loginHelperMap.get(loginType);
        UserDetails login = loginHelper.login(username, password);
        if (login==null){
            throw new SimplePoseidonCheckException("用户信息不存在");
        }
        return login;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userInfoManager.loadUserByUsername(username);
    }
}
