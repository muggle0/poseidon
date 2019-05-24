package com.muggle.poseidon.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-05-24
 **/

@Data
@Accessors(chain = true)
public class PoseidonClientDetails implements ClientDetails {

    private String clientId;

    private Set<String> resourceIds;

    private boolean secretRequired;

    private String clientSecret;

    protected boolean scoped;

    private Set<String> scope;

    private Set<String> authorizedGrantTypes;

    private Set<String> registeredRedirectUri;

    private Collection<GrantedAuthority> authorities;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    private boolean autoApprove;

    private  Map<String, Object> additionalInformation;

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }
}
