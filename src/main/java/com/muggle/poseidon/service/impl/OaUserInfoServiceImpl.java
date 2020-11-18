package com.muggle.poseidon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.muggle.poseidon.entity.dto.OaRoleDTO;
import com.muggle.poseidon.entity.form.OaUserForm;
import com.muggle.poseidon.entity.pojo.OaRole;
import com.muggle.poseidon.entity.pojo.OaUserInfo;
import com.muggle.poseidon.entity.vo.OaUserVO;
import com.muggle.poseidon.mapper.OaRoleMapper;
import com.muggle.poseidon.mapper.OaUserInfoMapper;
import com.muggle.poseidon.mapstruct.UserInfoMapstruct;
import com.muggle.poseidon.service.IOaUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.tool.UserInfoTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author muggle
 * @since 2020-11-11
 */
@Service
public class OaUserInfoServiceImpl extends ServiceImpl<OaUserInfoMapper, OaUserInfo> implements IOaUserInfoService {

    @Autowired
    private OaUserInfoMapper userInfoMapper;
    @Autowired
    private OaRoleMapper roleMapper;
    @Autowired
    private UserInfoMapstruct userInfoMapstruct;


    /**
     * 注册账号，只有管理员才有权限
     * @param userForm
     * @return
     */
    @Override
    public OaUserVO save(OaUserForm userForm) {
        QueryWrapper<OaRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(OaRole::getId,userForm.getRoleIds());
        List<OaRole> oaRoles = roleMapper.selectList(queryWrapper);
        List<OaRoleDTO> roleDTOList=new ArrayList<>();
        OaUserInfo localUser = UserInfoTool.getUserInfo();
        OaUserInfo userInfo=userInfoMapstruct.geUserInfo(userForm,localUser);
        /** 账号被注册，但被锁定，需要激活*/
        userInfoMapper.insert(userInfo);
        /** 保存用户角色 */
        oaRoles.forEach(role->{
            OaRoleDTO oaRoleDTO = new OaRoleDTO();
            oaRoleDTO.setUserId(userInfo.getId());
            oaRoleDTO.setUsername(userInfo.getUsername());
            oaRoleDTO.setRoleCode(role.getRoleCode());
            oaRoleDTO.setId(role.getId());
            roleDTOList.add(oaRoleDTO);
        });
        roleMapper.insertRelation(roleDTOList);
        OaUserVO userVO = userInfoMapstruct.getUserVO(userInfo);
        List<String> roleCodes = oaRoles.stream().map(OaRole::getRoleCode).collect(Collectors.toList());
        userVO.setRoles(roleCodes);
        return userVO;
    }

    @Override
    public OaUserVO getUserInfo() {
        OaUserInfo userInfo = UserInfoTool.getUserInfo();
        OaUserInfo dbUserInfo = userInfoMapper.selectById(userInfo.getId());
        dbUserInfo.setAuthorities(userInfo.getAuthorities());
        OaUserVO oaUserVO = userInfoMapstruct.getUserVO(dbUserInfo);
        return oaUserVO;
    }
}
