package com.sofia.poseidon.helper;

import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/12
 **/
public interface LoginHelper {

    UserDetails login(String username, String password)throws SimplePoseidonCheckException;
}
