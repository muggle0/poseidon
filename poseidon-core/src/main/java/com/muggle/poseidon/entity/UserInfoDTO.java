package com.muggle.poseidon.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-05-21
 **/
@Builder
@Data
public class UserInfoDTO {
    private String username;
    private String nickname;
    private String id;
    private Date birthday;
    private String phone;
    private String imgUrl;
    List<String> roleCodes;
}
