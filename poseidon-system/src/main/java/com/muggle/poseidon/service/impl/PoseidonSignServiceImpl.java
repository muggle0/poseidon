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
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public ResultBean getSigns() {
        String id = UserInfoService.getUser().getId();
        PoseidonSign poseidonSign = new PoseidonSign().setUserId(id);
        final List<PoseidonSign> allByUserId = findAll(poseidonSign);
        return ResultBean.getInstance(allByUserId);
    }

//    绑定账号
    @Transactional
    @Override
    public ResultBean insert(PoseidonSign poseidonSign, String validata) {
        String key = TokenProperties.VERIFICATION + "-" + poseidonSign.getPrincipal();
         PoseidonSign field = new PoseidonSign().setEnable(1).setAuthType(poseidonSign.getAuthType()).setPrincipal(poseidonSign.getPrincipal());
        if (!validata.equals(redisService.get(key))) {
            return ResultBean.getInstance("500", "验证码错误");
        }
        PoseidonUserDetail user = UserInfoService.getUser();
        if (!poseidonSign.getUserId().equals(user.getId())) {
            return ResultBean.getInstance("500", "请校验登录信息");
        }

         if ( count(field)>0){
            return ResultBean.getInstance("500","已经绑定其他账号，请先解绑");
        }

        poseidonSign.setCreateTime(new Date()).setEnable(1);
        log.info("插入数据："+poseidonSign.toString());
        PoseidonSign save = repository.save(poseidonSign);
        return ResultBean.getInstance(save);
    }

    @Transactional
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
        Optional<PoseidonSign> one = findOne(poseidonSign.getId());
        if (!one.isPresent()) {
            return ResultBean.getInstance("500", "信息不存在");
        }
        boolean equals = one.get().getUserId().equals(user.getId());
        if (equals) {
            poseidonSign.setUpdateTime(new Date()).setEnable(1);
            log.info("更新sign: "+poseidonSign.toString());
            repository.save(poseidonSign);
            return ResultBean.getInstance(poseidonSign);
        }
        return ResultBean.getInstance("500", "非法的操作");
    }

    @Transactional
    @Override
    public ResultBean delete(String id) {
        PoseidonUserDetail user = UserInfoService.getUser();
        Optional<PoseidonSign> byId =findOne(id);
        PoseidonSign poseidonSign = byId.get();
        if (byId.isPresent() && poseidonSign.getUserId().equals(user.getId())) {
            poseidonSign.setDeleteTime(new Date());
            log.info("删除sign id :"+poseidonSign.getId());
            repository.save(poseidonSign);
            return ResultBean.getInstance();
        }
        return ResultBean.getInstance("500","非法操作");
    }

    @Transactional
    @Override
    public ResultBean getSignById(String id) {
        Optional<PoseidonSign> one = findOne(id);
        if (!one.isPresent()){
            return ResultBean.getInstance("500","数据不存在");
        }
        return ResultBean.getInstance(one.get());
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

    private Optional<PoseidonSign> findOne(String id) {
        Optional<PoseidonSign> one = repository.findOne((root, query, builder) -> {
            Predicate predicate = builder.isNull(root.get("deleteTime"));
            predicate = builder.and(predicate, builder.equal(root.get("id"), id));
            return query.where(predicate).getRestriction();
        });
        return one;
    }

    public Long count(PoseidonSign poseidonSign) {
        final long count = repository.count((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            if (poseidonSign.getEnable() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("enable"), poseidonSign.getEnable()));
            }
            if (poseidonSign.getAuthType() != null) {
                predicate=criteriaBuilder.equal(root.get("authType"), poseidonSign.getAuthType());
            }
            if (poseidonSign.getUserId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("userId"), poseidonSign.getUserId()));
            }
            if (poseidonSign.getPrincipal() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("principal"), poseidonSign.getPrincipal()));
            }
            return criteriaQuery.where(predicate).getRestriction();
        });
        return count;
    }
}
