package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.UserMessage;
import com.muggle.poseidon.manager.UserInfoManagerImpl;
import com.muggle.poseidon.repos.UserMessageRepository;
import com.muggle.poseidon.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-01-04 13:46
 **/
@Service
public class UserMessageServiceImpl implements UserMessageService {
    @Autowired
    UserMessageRepository repository;
    @Override
    public ResultBean getMessage() {
        UserMessage userMessage = new UserMessage();
        userMessage.setUserId(UserInfoManagerImpl.getUser().getId());
        userMessage.setMessageType("leaveWord");
        userMessage.setMarkRead(0);
        List<UserMessage> all = findAll(userMessage);
        return ResultBean.getInstance(all);
    }
    @Transactional
    @Override
    public ResultBean getAll(UserMessage message) {
        String id = UserInfoManagerImpl.getUser().getId();
        boolean equals=!(message.getUserId().equals(id))&&!(message.getCreateId().equals(id));
        if (equals){
            return ResultBean.getInstance("500","非法操作");
        }
        List<UserMessage> all = findAll(message);
        return ResultBean.getInstance(all);
    }

    @Transactional
    @Override
    public ResultBean update(UserMessage userMessage) {
        String id = UserInfoManagerImpl.getUser().getId();
        boolean equals=!(userMessage.getUserId().equals(id))&&!(userMessage.getCreateId().equals(id));
        if (equals){
            return ResultBean.getInstance("500","非法操作");
        }
        userMessage.setUpdateTime(new Date());
        repository.save(userMessage);
        return ResultBean.getInstance(userMessage);
    }

    @Transactional
    @Override
    public ResultBean insert(UserMessage userMessage) {
        String id = UserInfoManagerImpl.getUser().getId();
        boolean equals=!(userMessage.getUserId().equals(id))&&!(userMessage.getCreateId().equals(id));
        if (equals){
            return ResultBean.getInstance("500","非法操作");
        }
        userMessage.setMarkRead(0).setCreateTime(new Date());
        repository.save(userMessage);
        return  ResultBean.getInstance(userMessage);
    }

    @Transactional
    @Override
    public ResultBean delete(String messageId) {
        Optional<UserMessage> one = findOne(messageId);
        if (!one.isPresent()){
            return ResultBean.getInstance("500","数据不存在");
        }
        UserMessage userMessage = one.get();
        String id = UserInfoManagerImpl.getUser().getId();
        if (!id.equals(userMessage.getCreateId())){
            return ResultBean.getInstance("500","不能删除他人消息");
        }
        userMessage.setDeleteTime(new Date());
       repository.save(userMessage);
       return ResultBean.getInstance();
    }

    @Override
    public ResultBean countNoRead(UserMessage userMessage) {
        String id = UserInfoManagerImpl.getUser().getId();
        boolean equals=!(userMessage.getUserId().equals(id))&&!(userMessage.getCreateId().equals(id));
        if (equals){
            return ResultBean.getInstance("500","非法操作");
        }
        Long count = count(userMessage);
        return ResultBean.getInstance(count);
    }


    Optional<UserMessage> findOne(String id){
        Optional<UserMessage> one = repository.findOne((root, query, builder) -> {
            Predicate predicate = builder.isNull(root.get("deleteTime"));
            predicate=builder.and(predicate,builder.equal(root.get("id"),id));
            return query.where(predicate).getRestriction();
        });
        return one;
    }


    public Long count(UserMessage message) {
        final long count = repository.count((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            if (message.getCreateId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("createId"), message.getCreateId()));
            }
            if (message.getMarkRead() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("markRead"), message.getMarkRead()));
            }
            if (message.getUserId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("userId"), message.getUserId()));
            }
            if (message.getMessageType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("messageType"),message.getMessageType()));
            }
            return criteriaQuery.where(predicate).getRestriction();
        });
        return count;
    }

    private List<UserMessage> findAll(UserMessage message) {
        List<UserMessage> all = repository.findAll((root, query, builder) -> {
            Predicate predicate = builder.isNull(root.get("deleteTime"));
            if (message.getUserId() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("userId"), message.getUserId()));
            }
            if (message.getMarkRead() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("markRead"), message.getMarkRead()));
            }
            if (message.getMessageType() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("messageType"), message.getMessageType()));
            }
            if (message.getCreateId() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("createId"), message.getCreateId()));
            }
            return query.where(predicate).getRestriction();
        });
        return all;
    }


}
