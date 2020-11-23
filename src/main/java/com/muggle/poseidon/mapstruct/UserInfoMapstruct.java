package com.muggle.poseidon.mapstruct;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.muggle.poseidon.entity.form.OaUserForm;
import com.muggle.poseidon.entity.pojo.OaUserInfo;
import com.muggle.poseidon.entity.vo.OaUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/17
 **/
@Mapper(componentModel="spring")
@Repository
public interface UserInfoMapstruct {
    @Mappings({
            @Mapping(target = "introduction", source = "userSign"),
            @Mapping(target = "avatar", source = "imgPath"),
            @Mapping(target = "name", source = "nickname"),
            @Mapping(target = "roles", source = "authorities"),
    })
     OaUserVO getUserVO(OaUserInfo oaUserInfo);

   default List<String>  authoritiesToRoles(List<SimpleGrantedAuthority> authorities){
       if (CollectionUtils.isEmpty(authorities)){
           return Collections.emptyList();
       }
       return authorities.stream().map(SimpleGrantedAuthority::getAuthority).collect(Collectors.toList());
   }
    OaUserInfo formToUserInfo(OaUserForm oaUserForm);
    default OaUserInfo geUserInfo(OaUserForm userForm,OaUserInfo localUser){
        OaUserInfo oaUserInfo = formToUserInfo(userForm);
        oaUserInfo.setModifyUserId(localUser.getModifyUserId());
        oaUserInfo.setGmtModified(LocalDateTime.now());
        oaUserInfo.setEnabled(true);
        oaUserInfo.setAccountNonExpired(true);
        oaUserInfo.setAccountNonLocked(false);
        oaUserInfo.setCredentialsNonExpired(true);
        return oaUserInfo;
    }

    default OaUserInfo UserinfouserFormToUser(OaUserForm userForm){
        OaUserInfo oaUserInfo = new OaUserInfo();
        oaUserInfo.setAddress(userForm.getAddress());
        oaUserInfo.setBank(userForm.getBank());
        oaUserInfo.setBirth(userForm.getBirth());
        oaUserInfo.setEamil(userForm.getEamil());
        oaUserInfo.setIdCard(userForm.getIdCard());
        oaUserInfo.setImgPath(userForm.getImgPath());
        oaUserInfo.setRealName(userForm.getRealName());
        oaUserInfo.setUserSchool(userForm.getUserSchool());
        oaUserInfo.setUserEdu(userForm.getUserEdu());
        oaUserInfo.setUserSign(userForm.getUserSign());
        oaUserInfo.setUserTel(userForm.getUserTel());
        oaUserInfo.setNickname(userForm.getUserTel());
        return oaUserInfo;
    }
}
