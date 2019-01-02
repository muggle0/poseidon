package com.muggle.poseidon.model.vo;

import lombok.Data;

/**
 * @author ：muggle
 * @date ：Created in 2019/1/1
 * @description：将用户信息展示给前端的model
 * @version:
 */
@Data
public class UserVO {
    private String id;
    private String nickname;
    private Integer gender;
    private String email;
    private String imgUrl;
}
