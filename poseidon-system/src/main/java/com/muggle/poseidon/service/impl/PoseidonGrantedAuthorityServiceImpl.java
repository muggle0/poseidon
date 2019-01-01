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
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("enabled"), true));
            if (authority.getUrl() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("url"), authority.getUrl()));
            }
            if (authority.getMethod() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("nickname"), authority.getMethod()));
            }
            if (authority.getPermissionName() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("phone"), authority.getPermissionName()));
            }
            return criteriaQuery.where(predicate).getRestriction();
        });
        return count;
    }
}
