package com.muggle.poseidon.entity.vo;

import java.util.List;

import com.muggle.poseidon.entity.pojo.OaUserInfo;
import lombok.Data;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/16
 **/
@Data
public class OaUserVO {
    private String introduction;

    private String avatar;

    private String name;

    private List<String> roles;
}
