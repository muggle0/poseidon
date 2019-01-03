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

import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        return ResultBean.getInstance("500", "验证码错误");
    }

    @Override
    public ResultBean update(PoseidonSign poseidonSign, String validata) {
        String key = TokenProperties.VERIFICATION + "-" + poseidonSign.getPrincipal();
        if (!validata.equals(redisService.get(key))) {
            return ResultBean.getInstance("500", "验证码错误");
        }
        PoseidonUserDetail user = UserInfoService.getUser();
        if (!poseidonSign.getUserId().equals(user.getId())) {
            return ResultBean.getInstance("500", "请校验登录信息");
        }
        Optional<PoseidonSign> byId = repository.findById(poseidonSign.getId());
        if (!byId.isPresent()) {
            return ResultBean.getInstance("500", "信息不存在");
        }
        boolean equals = byId.get().getUserId().equals(user.getId());
        if (equals) {
            repository.save(poseidonSign);
            return ResultBean.getInstance(poseidonSign);
        }
        return ResultBean.getInstance("500", "非法的操作");
    }

    @Override
    public ResultBean delete(String id) {
        PoseidonUserDetail user = UserInfoService.getUser();
        Optional<PoseidonSign> byId = repository.findById(id);
        PoseidonSign poseidonSign = byId.get();
        if (byId.isPresent() && poseidonSign.getUserId().equals(user.getId())) {
            poseidonSign.setDeleteTime(new Date());
            repository.save(poseidonSign);
        }
        return ResultBean.getInstance();
    }

    private List<PoseidonSign> findAll(PoseidonSign poseidonSign) {
        List<PoseidonSign> all = repository.findAll((root, query, builder) -> {
            Predicate predicate = builder.isNull(root.get("deleteTime"));
            if (poseidonSign.getUserId() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("userId"), poseidonSign.getUserId()));
            }
            if (poseidonSign.getPrincipal() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("principal"), poseidonSign.getPrincipal()));
            }
            if (poseidonSign.getAuthType() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("authType"), poseidonSign.getAuthType()));
            }
            if (poseidonSign.getEnable() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("enable"), poseidonSign.getEnable()));
            }
            return query.where(predicate).getRestriction();
        });
        return all;
    }

    private Optional<PoseidonSign> findOne(PoseidonSign poseidonSign) {
        Optional<PoseidonSign> one = repository.findOne((root, query, builder) -> {
            Predicate predicate = builder.isNull(root.get("deleteTime"));
            predicate = builder.and(predicate, builder.equal(root.get("id"), poseidonSign.getId()));
            return query.where(predicate).getRestriction();
        });
        return one;
    }
}
