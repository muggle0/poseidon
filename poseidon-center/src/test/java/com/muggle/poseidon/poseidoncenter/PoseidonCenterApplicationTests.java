package com.muggle.poseidon.poseidoncenter;

import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.Role;
import com.muggle.poseidon.service.RoleServiceImpl;
import com.muggle.poseidon.service.impl.PoseidonUserdetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoseidonCenterApplicationTests {
    @Autowired
    PoseidonUserdetailsServiceImpl poseidonUserdetailsService;
   @Autowired
   RoleServiceImpl roleServiceImpl;

//    @Test
    public void contextLoads() {
        final PoseidonUserDetail userDetail = new PoseidonUserDetail().setUsername("admin");
        Long count =poseidonUserdetailsService.count(userDetail);
        System.out.println(count);

    }
    @Test
    public  void  findAll(){
        UserDetails one = poseidonUserdetailsService.loadUserByUsername("admin");
        System.out.println(one.getUsername());
    }

    @Test
    @Transactional
    public void testRole(){
        final Role role = new Role();
        role.setName("超级管理员");
        List<Role> one = roleServiceImpl.findAll(role);
        final Set<PoseidonGrantedAuthority> authorities = one.get(0).getAuthorities();
                System.out.println(one);
    }
}

