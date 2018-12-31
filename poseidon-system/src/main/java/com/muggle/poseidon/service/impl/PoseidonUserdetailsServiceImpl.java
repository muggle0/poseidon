package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.PoseidonException;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.repos.PoseidonSignRepository;
import com.muggle.poseidon.repos.PoseidonUserDetailsRepository;
import com.muggle.poseidon.service.OauthService;
import com.muggle.poseidon.service.PoseidonUserdetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-24 21:01
 **/
@Service
@Slf4j
public class PoseidonUserdetailsServiceImpl implements UserDetailsService,PoseidonUserdetailService {
    @Autowired
    PoseidonUserDetailsRepository repository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    PoseidonSignRepository signRepository;
    @Autowired
    OauthService oauthService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PoseidonUserDetail userDetail=repository.findDistinctByUsername(s);
        if (userDetail==null){
            throw  new UsernameNotFoundException("用户名不存在");
        }
        log.info("用户登录验证："+userDetail.toString());
        return  userDetail;
    }

    public ResultBean toSignUp(PoseidonUserDetail userDetail) {
        log.info("创建用户："+ userDetail.toString());
        String value=userDetail.getPassword();
        String password = passwordEncoder.encode(userDetail.getPassword());
        userDetail.setPassword(password);
         PoseidonUserDetail save = repository.save(userDetail);
         save.setPassword(value);
         if (save!=null){
             log.info("新增用户：{}",save.toString());
             return ResultBean.getInstance(save);
         }
         return ResultBean.getInstance("500","系统异常");
    }

    public UserDetails findOne(String id){
        Optional<PoseidonUserDetail> userDetail=repository.findById(id);
        return userDetail.get();
    }

    public PoseidonSign loadByPrincipal(String principal){
        PoseidonSign poseidonSign = signRepository.findByPrincipal(principal);
        String credentials = oauthService.getCredentialsByPrincipal(principal);
        poseidonSign.setCredentials(credentials);
        return poseidonSign;
    }

    @Override
    public ResultBean create() {
        PoseidonUserDetail userDetail=new PoseidonUserDetail();
        String admin = passwordEncoder.encode("admin-muggle");
        userDetail.setPassword(admin).setUsername("admin").setAccountNonLocked(true).setCredentialsNonExpired(true).setNickname("muggle")
                .setEnabled(true).setAccountNonExpired(true).setEmail("1977339740@qq.com").setGender(1).setImgUrl("localhost:8080/resources/admin.jpg");
        PoseidonUserDetail save=null;
        try {

            save= repository.save(userDetail);
            return ResultBean.getInstance(save);
        }catch (Exception e){
//            throw new PoseidonException("what 让 with you","6000");
            throw new RuntimeException("ss>>>>>>");
        }
    }
}
