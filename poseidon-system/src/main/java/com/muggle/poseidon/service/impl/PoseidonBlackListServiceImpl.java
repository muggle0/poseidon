package com.muggle.poseidon.service.impl;

import java.util.Date;
import java.util.List;


import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonBlackList;
import com.muggle.poseidon.repos.PoseidonBlackListRepository;
import com.muggle.poseidon.service.PoseidonBlackListService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * PoseidonBlackList的服务接口的实现类
 *
 * @author
 */
@Service
@Transactional
@Slf4j
public class PoseidonBlackListServiceImpl implements PoseidonBlackListService {

    @Autowired
    private PoseidonBlackListRepository poseidonBlackListRepository;


    @Override
    public ResultBean update(PoseidonBlackList bean) {
        bean.setUpdateTime(new Date());
        bean.setStatus(1);
        PoseidonBlackList save = poseidonBlackListRepository.save(bean);
        return ResultBean.getInstance(save);
    }

    @Override
    public ResultBean delete(String id) {
        final Optional<PoseidonBlackList> one = findOne(id);
        if (one.isPresent()) {
            PoseidonBlackList poseidonBlackList = one.get();
            poseidonBlackList.setDeleteTime(new Date());
            poseidonBlackListRepository.save(poseidonBlackList);
            return ResultBean.getInstance();
        }
        return ResultBean.getInstance("500", "数据不存在");

    }

    @Override
    public Optional<PoseidonBlackList> findOne(String id) {
        Optional<PoseidonBlackList> one = poseidonBlackListRepository.findOne((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), id));
            return criteriaQuery.where(predicate).getRestriction();
        });
        return one;
    }

    @Override
    public List<PoseidonBlackList> find(PoseidonBlackList bean) {
        final List<PoseidonBlackList> all = poseidonBlackListRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            if (bean.getStatus() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), bean.getStatus()));
            }
            if (bean.getReason() != null) {
                Predicate where = criteriaBuilder.equal(root.get("reason"), bean.getReason());
                where = criteriaBuilder.or(where, criteriaBuilder.equal(root.get("method"), "ALL"));
                predicate = criteriaBuilder.and(predicate, where);
            }
            if (bean.getRemark() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("remark"), bean.getRemark()));
            }
            if (bean.getUserId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("userId"), bean.getUserId()));
            }

            return criteriaQuery.where(predicate).getRestriction();
        });
        return all;
    }

    @Override
    public long count(PoseidonBlackList bean) {
        long count = poseidonBlackListRepository.count((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            if (bean.getStatus() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), bean.getStatus()));
            }
            if (bean.getReason() != null) {
                Predicate where = criteriaBuilder.equal(root.get("reason"), bean.getReason());
                where = criteriaBuilder.or(where, criteriaBuilder.equal(root.get("method"), "ALL"));
                predicate = criteriaBuilder.and(predicate, where);
            }
            if (bean.getRemark() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("remark"), bean.getRemark()));
            }
            if (bean.getUserId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("userId"), bean.getUserId()));
            }

            return criteriaQuery.where(predicate).getRestriction();
        });
        return count;
    }

    @Override
    public ResultBean insert(List<PoseidonBlackList> lists) {
        lists.forEach(poseidonBlackList -> {
            poseidonBlackList.setCreateTime(new Date());
            poseidonBlackList.setStatus(1);
        });
        Iterable<PoseidonBlackList> poseidonBlackLists = poseidonBlackListRepository.saveAll(lists);
        return ResultBean.getInstance(poseidonBlackLists);
    }
}