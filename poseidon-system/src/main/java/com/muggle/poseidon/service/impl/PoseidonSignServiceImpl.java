package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.core.properties.TokenProperties;
import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.repos.PoseidonSignRepository;
import com.muggle.poseidon.service.PoseidonSignService;
import com.muggle.poseidon.service.RedisService;
import com.muggle.poseidon.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：muggle
 * @date ：Created in 2019/1/3
 * @description：
 * @version:
 */
@Service
@Slf4j
public class PoseidonSignServiceImpl implements PoseidonSignService {
    @Autowired
    PoseidonSignRepository repository;
    @Autowired
    RedisService redisService;


    @Override
    public ResultBean getSigns() {
        String id = UserInfoService.getUser().getId();
        final List<PoseidonSign> allByUserId = repository.findAllByUserId(id);
        return ResultBean.getInstance(allByUserId);
    }

    @Override
    public ResultBean insert(PoseidonSign poseidonSign, String validata) {
        PoseidonUserDetail user = UserInfoService.getUser();
        if (!poseidonSign.getUserId().equals(user.getId())) {
            return ResultBean.getInstance("500", "请校验登录信息");
        }
        String key = TokenProperties.VERIFICATION + "-" + poseidonSign.getPrincipal();
        if (validata.equals(redisService.get(key))) {
            repository.save(poseidonSign);
        }
        return ResultBean.getInstance("500","验证码错误");
    }

}
