package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.PoseidonException;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.core.properties.TokenProperties;
import com.muggle.poseidon.model.*;
import com.muggle.poseidon.model.vo.VerifVO;
import com.muggle.poseidon.repos.*;
import com.muggle.poseidon.service.OauthService;
import com.muggle.poseidon.service.RedisService;
import com.muggle.poseidon.utils.VerificationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class MessageOauthService implements OauthService {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    PoseidonUserDetailsRepository repository;
    @Autowired
    RedisService redisService;
    @Autowired
    PoseidonRoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    PoseidonGrantedAuthorityRepository authorityRepository;
    @Autowired
    RoleGrantedRepository roleGrantedRepository;



    @Transactional
    @Override
    public ResultBean create() {
        PoseidonUserDetail userDetail = new PoseidonUserDetail();
        String admin = passwordEncoder.encode("muggle");
        userDetail.setPassword(admin).setUsername("admin").setAccountNonLocked(true)
                .setCredentialsNonExpired(true).setNickname("muggle")
                .setEnabled(true).setAccountNonExpired(true).setEmail("1977339740@qq.com")
                .setGender(1).setImgUrl("localhost:8080/resources/admin.jpg");
        PoseidonUserDetail userSave = null;
        try {
            userSave = repository.save(userDetail);
            Role role = new Role().setSort(0).setName("超级管理员").setRoleCode("admin:").setEnable(true).setCreateTime(new Date());
            role = roleRepository.save(role);
//          新建一个普通用户角色 供新建用户登录
            Role baesRole=new Role().setRoleCode("base").setCreateTime(new Date()).setEnable(true).setName("基础角色").setSort(1);
            UserRole userRole = new UserRole().setRoleId(role.getId()).setUserId(userSave.getId());
            userRole = userRoleRepository.save(userRole);
            PoseidonGrantedAuthority authority = new PoseidonGrantedAuthority();
            authority.setAuthority("ROLE_admin").setMethod("ALL").setUrl("/**").setEnable(true)
                    .setPermissionName("超级管理员").setCreateTime(new Date());
            authority.setHashCode(String.valueOf(authority.hashCode()));
            authority = authorityRepository.save(authority);
            RoleGranted roleGranted = new RoleGranted();
            roleGranted.setGrantedId(authority.getId());
            roleGranted.setRoleId(role.getId());
            roleGrantedRepository.save(roleGranted);
//            userSave.setPassword("muggle");
            return ResultBean.getInstance(userSave);
        } catch (Exception e) {
            throw new PoseidonException("what's wrong with you hahahahahahahah", "6000");
        }
    }
//    客户端获取验证码
    @Override
    public ResultBean getVerification(VerifVO verifVO) {
        switch (verifVO.getCode()){
            //        图片验证码
            case 1:
                String key = TokenProperties.VERIFICATION + "-"+verifVO.getUsername();
                String randonString = VerificationUtils.getRandonString(4);
                log.info("验证码: {}", randonString);
                redisService.setForTimeMIN(key, randonString, 5);
                final String s = redisService.get(key);
                System.out.println(s);
                return ResultBean.getInstance(randonString);
//                TODO 手机验证码
            case 2:
                return null;
//                TODO email 验证
            default:
                return null;
        }
    }
}
