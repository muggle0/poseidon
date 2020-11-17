package com.muggle.poseidon.mapstruct;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
@Mapper(componentModel="spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
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

}
