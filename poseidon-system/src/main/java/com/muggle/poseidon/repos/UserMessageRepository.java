package com.muggle.poseidon.repos;

import com.muggle.poseidon.entity.UserMessage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessageRepository extends CrudRepository<UserMessage, String>, JpaSpecificationExecutor<UserMessage> {
}
