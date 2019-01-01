package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.PoseidonException;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.core.properties.TokenProperties;
import com.muggle.poseidon.model.*;
import com.muggle.poseidon.repos.*;
import com.muggle.poseidon.service.AdminService;
import com.muggle.poseidon.service.RedisService;
import com.muggle.poseidon.utils.VerificationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author ：muggle
 * @date ：Created in 2018/12/31
 * @description：管理员
 * @version:
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
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

    @Override
    public ResultBean getVerification(PoseidonUserDetail poseidonUserDetail) {
//        todo 短信获取验证码 微信获取验证码
        String key = TokenProperties.VERIFICATION + "-" + poseidonUserDetail.getPassword() + "-" + poseidonUserDetail.getUsername();
        String randonString = VerificationUtils.getRandonString(4);
        log.info("验证码: {}", randonString);
        redisService.setForTimeMIN(key, randonString, 5);
        final String s = redisService.get(key);
        System.out.println(s);
        return ResultBean.getInstance(randonString);
    }
}
