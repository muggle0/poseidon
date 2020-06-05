package com.muggle.poseidon.oa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.entity.oa.OaRole;
import com.muggle.poseidon.oa.mapper.OaRoleMapper;
import com.muggle.poseidon.service.oa.IOaRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author muggle
 * @since 2020-05-29
 */
@Service
public class OaRoleServiceImpl extends ServiceImpl<OaRoleMapper, OaRole> implements IOaRoleService {


    @Override
    public OaRole saveOaRole(OaRole oaRole) {

        return null;
    }
}
