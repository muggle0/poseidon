package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.repos.PoseidonSignRepository;
import com.muggle.poseidon.service.PoseidonSignService;
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


    @Override
    public ResultBean getSigns() {
        String id = UserInfoService.getUser().getId();
        final List<PoseidonSign> allByUserId = repository.findAllByUserId(id);
        return ResultBean.getInstance(allByUserId);
    }
}
