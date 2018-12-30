package com.muggle.poseidon.core.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * @program: poseidon
 * @description: URL权限填充
 * @author: muggle
 * @create: 2018-12-30 11:39
 **/

public class PoseidonFilterInvocationSecurityMetadataSource extends DefaultFilterInvocationSecurityMetadataSource {
    public PoseidonFilterInvocationSecurityMetadataSource(LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap) {
        super(requestMap);
    }
}
