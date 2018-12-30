package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.repos.PoseidonSignRepository;
import com.muggle.poseidon.repos.PoseidonUserDetailsRepository;
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
public class PoseidonUserdetailsService implements UserDetailsService{
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
}
