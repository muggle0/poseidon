package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import com.muggle.poseidon.repos.PoseidonGrantedAuthorityRepository;
import com.muggle.poseidon.service.PoseidonGrantedAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

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
        return null;
    }

    @Override
    public ResultBean delete(List<String> ids) {
        return null;
    }

    @Override
    public ResultBean show(PoseidonGrantedAuthority bean) {
        return null;
    }

    @Override
    public ResultBean query(PoseidonGrantedAuthority bean) {
        return null;
    }

    @Override
    public ResultBean export(PoseidonGrantedAuthority bean) {
        return null;
    }

    @Override
    public Long count(PoseidonGrantedAuthority authority) {
        final long count = repository.count((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            if (authority.getUrl() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("url"), authority.getUrl()));
            }
            if (authority.getMethod() != null) {
                Predicate where=criteriaBuilder.equal(root.get("method"), authority.getMethod());
                where=criteriaBuilder.or(where,criteriaBuilder.equal(root.get("method"),"ALL"));
                predicate=criteriaBuilder.and(predicate,where);
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
