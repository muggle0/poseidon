package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.PoseidonException;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.core.properties.TokenProperties;
import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.repos.PoseidonSignRepository;
import com.muggle.poseidon.repos.PoseidonUserDetailsRepository;
import com.muggle.poseidon.service.OauthService;
import com.muggle.poseidon.service.PoseidonUserdetailService;
import com.muggle.poseidon.service.RedisService;
import com.muggle.poseidon.utils.VerificationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.muggle.poseidon.core.properties.PoseidonProperties;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-24 21:01
 **/
@Service
@Slf4j
public class PoseidonUserdetailsServiceImpl implements UserDetailsService, PoseidonUserdetailService {
    @Autowired
    PoseidonUserDetailsRepository repository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    PoseidonSignRepository signRepository;
    @Autowired
    OauthService oauthService;
    @Autowired
    RedisService redisService;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PoseidonUserDetail userDetail = repository.findDistinctByUsername(s);
        if (userDetail == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.info("用户登录验证：" + userDetail.toString());
        return userDetail;
    }

    @Transactional()
    public ResultBean toSignUp(PoseidonUserDetail userDetail,String verification) {
        String key=TokenProperties.VERIFICATION + "-"+userDetail.getPassword()+"-"+userDetail.getUsername();
        String s = redisService.get(key);
        if (s==null){
            throw new PoseidonException("验证码过期",PoseidonProperties.COMMIT_DATA_ERROR);
        }
        if (!verification.equals(s)){
            throw new PoseidonException("验证码错误",PoseidonProperties.COMMIT_DATA_ERROR);
        }

        log.info("创建用户：" + userDetail.toString());
        String value = userDetail.getPassword();
        String password = passwordEncoder.encode(userDetail.getPassword());
        userDetail.setPassword(password);
        userDetail.setCreatTime(LocalDateTime.now()).setEnabled(true)
                .setAccountNonExpired(true).setAccountNonLocked(true).setCredentialsNonExpired(true);
        try {
            PoseidonUserDetail save = repository.save(userDetail);
            save.setPassword(value);
                log.info("新增用户：{}", save.toString());
                return ResultBean.getInstance(save);
        }catch (Exception e){
            return ResultBean.getInstance(PoseidonProperties.COMMIT_DATA_ERROR, "用户名已存在");
        }
    }

    public UserDetails findOne(String id) {
        Optional<PoseidonUserDetail> userDetail = repository.findById(id);
        return userDetail.get();
    }

    public PoseidonSign loadByPrincipal(String principal) {
        PoseidonSign poseidonSign = signRepository.findByPrincipal(principal);
        String credentials = oauthService.getCredentialsByPrincipal(principal);
        poseidonSign.setCredentials(credentials);
        return poseidonSign;
    }


}
