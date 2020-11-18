package com.muggle.poseidon.entity.form;

import javax.validation.constraints.NotNull;
import java.util.List;

import com.muggle.poseidon.entity.pojo.OaUserInfo;
import lombok.Data;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/18
 **/
@Data
public class OaUserForm extends OaUserInfo {
    @NotNull(message = "请选择用户权限")
    private List<Long> roleIds;

}
