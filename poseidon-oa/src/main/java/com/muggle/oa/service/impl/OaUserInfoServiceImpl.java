package com.muggle.oa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.oa.entity.OaUserInfo;
import com.muggle.oa.mapper.OaUserInfoMapper;
import com.muggle.oa.service.IOaUserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author muggle
 * @since 2020-05-24
 */
@Service
public class OaUserInfoServiceImpl extends ServiceImpl<OaUserInfoMapper, OaUserInfo> implements IOaUserInfoService {

}
