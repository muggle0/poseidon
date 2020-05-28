package com.muggle.poseidon.oa.security;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.entity.AuthUrlPathDO;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.oa.mapper.OaUserInfoMapper;
import com.muggle.poseidon.service.TokenService;
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
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
      /*  for (int i = 0; i < list.size(); i++) {
            AuthUrlPathDO bean = list.get(i);
            if (bean.getMethodURL().contains("/error") || bean.getMethodURL().contains("/swagger")) {
                continue;
            }
            String className = bean.getClassName();
            UserAuthority userAuthority = authMap.get(className);
            UserAuthority child = new UserAuthority();
            BeanUtils.copyProperties(bean, child);
            child.setId(idGenerator.nextId());
            child.setUrl(bean.getMethodURL() + "/**");
            child.setDescription(bean.getMethodDesc());
            child.setGmtCreate(new Date());
            child.setEnable(true);
            if (userAuthority == null) {
                UserAuthority parentAuth = new UserAuthority();
                BeanUtils.copyProperties(bean, parentAuth);
                parentAuth.setUrl(bean.getClassUrl() + "/**");
                parentAuth.setDescription(bean.getClassDesc());
                parentAuth.setGmtCreate(new Date());
                parentAuth.setEnable(true);
                parentAuth.setMethodName(null);
                parentAuth.setRequestType(null);
                long parentId = idGenerator.nextId();
                parentAuth.setId(parentId);
                authMap.put(parentAuth.getClassName(), parentAuth);
                child.setParentId(parentId);
            } else {
                child.setParentId(userAuthority.getId());
            }
            userAuthorities.add(child);
        }
        userAuthorities.addAll(authMap.values());
        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setDescription("管理员权限").setEnable(true);
        userAuthority.setGmtCreate(new Date())
                .setUrl("/**").setApplication(appName).setId(idGenerator.nextId());
        userAuthorities.add(userAuthority);
        // do*/
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
