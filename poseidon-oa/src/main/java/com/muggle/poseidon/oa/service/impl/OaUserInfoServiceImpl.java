package com.muggle.poseidon.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.base.OAException;
import com.muggle.poseidon.entity.oa.OaRole;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.entity.oa.vo.OaUserVO;
import com.muggle.poseidon.oa.entity.UserRoleRelationDO;
import com.muggle.poseidon.oa.mapper.OaRoleMapper;
import com.muggle.poseidon.oa.mapper.OaUserInfoMapper;
import com.muggle.poseidon.oa.security.OaUserInfoTool;
import com.muggle.poseidon.oa.service.helper.UserHelper;
import com.muggle.poseidon.service.oa.IOaUserInfoService;
import com.muggle.poseidon.util.PoseidonIdGenerator;
import com.muggle.poseidon.util.RequestUtils;
import com.muggle.poseidon.util.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author muggle
 * @since 2020-05-28
 */
@Service
@Validated
public class OaUserInfoServiceImpl extends ServiceImpl<OaUserInfoMapper, OaUserInfo> implements IOaUserInfoService {

    @Autowired
    OaRoleMapper oaRoleMapper;

    @Autowired
    PoseidonIdGenerator idGenerator;

    @Override
    public OaUserInfo regester(OaUserVO userVO) {
        HashMap<String, Object> queryMap = new HashMap<>();
        QueryWrapper<OaUserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userVO.getUsername());
        Integer userCount = baseMapper.selectCount(queryWrapper);
        if (userCount>0){
            throw new OAException("该用户名已存在");
        }
        OaUserInfo oaUserInfo =UserHelper.newUserInfo(userVO);
        oaUserInfo.setUserId(idGenerator.simpleNextId());
        baseMapper.insert(oaUserInfo);
        OaRole guest = oaRoleMapper.selectOne(new LambdaQueryWrapper<OaRole>().eq(OaRole::getRoleCode, "GUEST"));
        UserRoleRelationDO relationDO = new UserRoleRelationDO();
        relationDO.setRoleId(guest.getRoleId()).setRoleCode(guest.getRoleCode());
        relationDO.setUserId(oaUserInfo.getUserId()).setUserName(oaUserInfo.getUsername());
        oaRoleMapper.insertRelation(relationDO);
        oaUserInfo.setAuthorities(Arrays.asList(guest));
        return oaUserInfo;
    }

    @Override
    public OaUserInfo getUserInfo(String username) {
        QueryWrapper<OaUserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        OaUserInfo oaUserInfo = baseMapper.selectOne(queryWrapper);
        if (oaUserInfo==null){
            throw new OAException("找不到该用户");
        }
        List<OaRole> roles = oaRoleMapper.selectByUsername(username);
        oaUserInfo.setAuthorities(roles);
        return oaUserInfo;
    }
}
