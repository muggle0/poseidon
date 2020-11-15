package com.muggle.poseidon.service.impl;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.muggle.poseidon.base.OaBusinessException;
import com.muggle.poseidon.base.OaExceptionEnum;
import com.muggle.poseidon.entity.dto.OaAuthorityDTO;
import com.muggle.poseidon.entity.form.AuthorityForm;
import com.muggle.poseidon.entity.pojo.OaAuthority;
import com.muggle.poseidon.entity.pojo.OaRole;
import com.muggle.poseidon.entity.pojo.OaUserInfo;
import com.muggle.poseidon.mapper.OaAuthorityMapper;
import com.muggle.poseidon.mapper.OaRoleMapper;
import com.muggle.poseidon.service.IOaAuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.service.manager.OaAuthorityManager;
import com.muggle.poseidon.tool.UserInfoTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author muggle
 * @since 2020-11-12
 */
@Service
public class OaAuthorityServiceImpl extends ServiceImpl<OaAuthorityMapper, OaAuthority> implements IOaAuthorityService {
    @Autowired
    OaAuthorityManager authorityManager;

    @Autowired
    OaRoleMapper roleMapper;

    /**
     * @param authority
     * @return
     */
    @Override
    public Boolean addAuthority(OaAuthority authority) {
        OaAuthorityMapper oaAuthorityMapper = authorityManager.getOaAuthorityMapper();
        QueryWrapper<OaAuthority> queryWrapper = new QueryWrapper<>();
        OaAuthority oaAuthority = oaAuthorityMapper.selectOne(queryWrapper);
        if (oaAuthority != null) {
            throw new OaBusinessException("该权限编码已存在", OaExceptionEnum.OaCheckError.getCode());
        }
        OaUserInfo userInfo = UserInfoTool.getUserInfo();
        authority.setGmtCreated(LocalDateTime.now());
        authority.setGmtCreatorName(userInfo.getUsername());
        authority.setGmtCreator(userInfo.getId());
        oaAuthorityMapper.insert(authority);
        return true;
    }

    /**
     * @param authorityForm
     * @return
     */
    @Override
    public Boolean addRoleAuth(AuthorityForm authorityForm) {
        OaAuthorityMapper oaAuthorityMapper = authorityManager.getOaAuthorityMapper();
        OaAuthority oaAuthority = oaAuthorityMapper.selectById(authorityForm.getAuthId());
        OaRole oaRole = roleMapper.selectById(authorityForm.getRoleId());
        OaAuthorityDTO oaAuthorityDTO = new OaAuthorityDTO();
        BeanUtils.copyProperties(oaAuthority,oaAuthorityDTO);
        oaAuthorityMapper.insertRelation(oaAuthorityDTO);
        return null;
    }

}
