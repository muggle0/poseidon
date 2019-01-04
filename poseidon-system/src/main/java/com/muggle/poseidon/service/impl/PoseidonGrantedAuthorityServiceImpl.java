package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import com.muggle.poseidon.repos.PoseidonGrantedAuthorityRepository;
import com.muggle.poseidon.service.PoseidonGrantedAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author ：muggle
 * @date ：Created in 2019/1/1
 * @description：
 * @version:
 */
@Service
public class PoseidonGrantedAuthorityServiceImpl implements PoseidonGrantedAuthorityService {
    @Autowired
    PoseidonGrantedAuthorityRepository repository;


    @Override
    public ResultBean update(PoseidonGrantedAuthority bean) {
        PoseidonGrantedAuthority save = repository.save(bean);
        return ResultBean.getInstance(save);
    }

    @Override
    public ResultBean findAll(PoseidonGrantedAuthority authority) {
        List<PoseidonGrantedAuthority> all = repository.findAll((root, query, builder) -> {
            Predicate predicate = builder.isNull(root.get("deleteTime"));
            predicate = builder.and(predicate, builder.equal(root.get("enable"), authority.getEnable()));
            if (authority.getId() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("id"), authority.getId()));
            }
            if (authority.getPermissionName() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("permissionName"), authority.getPermissionName()));
            }
            if (authority.getMethod() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("method"), authority.getMethod()));
            }
            if (authority.getUrl() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("url"), authority.getUrl()));
            }
            return query.where(predicate).getRestriction();
        });
        return ResultBean.getInstance(all);
    }

    @Override
    public ResultBean insert(List<PoseidonGrantedAuthority> authorityList) {
        authorityList.forEach(authority -> {
            authority.setCreateTime(new Date());
            authority.setEnable(true);
        });
        Iterable<PoseidonGrantedAuthority> poseidonGrantedAuthorities = repository.saveAll(authorityList);
        return ResultBean.getInstance(poseidonGrantedAuthorities);
    }

    @Override
    public ResultBean delete(String id) {
        PoseidonGrantedAuthority poseidonGrantedAuthority = repository.findByIdAndDeleteTimeIsNull(id);
        if (poseidonGrantedAuthority==null){
            return ResultBean.getInstance("500","信息不存在");
        }
        poseidonGrantedAuthority.setDeleteTime(new Date());
        return ResultBean.getInstance();
    }

    @Override
    public Long count(PoseidonGrantedAuthority authority) {
        final long count = repository.count((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            if (authority.getUrl() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("url"), authority.getUrl()));
            }
            if (authority.getMethod() != null) {
                Predicate where = criteriaBuilder.equal(root.get("method"), authority.getMethod());
                where = criteriaBuilder.or(where, criteriaBuilder.equal(root.get("method"), "ALL"));
                predicate = criteriaBuilder.and(predicate, where);
            }
            if (authority.getPermissionName() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("permissionName"), authority.getPermissionName()));
            }
            if (authority.getEnable() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("enable"), authority.getEnable()));
            }
            return criteriaQuery.where(predicate).getRestriction();
        });
        return count;
    }

}
