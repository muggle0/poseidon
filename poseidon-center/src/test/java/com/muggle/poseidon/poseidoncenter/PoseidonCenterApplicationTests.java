package com.muggle.poseidon.poseidoncenter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.Role;
import com.muggle.poseidon.service.impl.RoleServiceImpl;
import com.muggle.poseidon.service.impl.PoseidonUserdetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
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

    @Test
    public void testJson(){
        char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ,
                'a','b','c','d','e','f','g','h','i','j','k','m','l','n','o','p',
                'q','r','s','t','u','v','w','x','y','z'};
        char [] code=new char[4];
        Random random=new Random();
        while (true){
            for (int i=0;i<4;i++){
                code[i]=codeSequence[random.nextInt(62)];
            }
            String s = String.valueOf(code);
            System.out.println(s);
        }

        /*PoseidonUserDetail userDetail = new PoseidonUserDetail();
        userDetail.setDeleteTime(new Date()).setEnabled(true);
        String s = JSONObject.toJSONString(userDetail);
        System.out.println(s);*/
    }

}

