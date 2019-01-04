package com.muggle.poseidon.repos;

import com.muggle.poseidon.model.PoseidonSign;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-28 19:20
 **/
@Repository
public interface PoseidonSignRepository extends CrudRepository<PoseidonSign, String>, JpaSpecificationExecutor<PoseidonSign> {
    List<PoseidonSign> findAllByUserId(String userid);
    PoseidonSign findByPrincipalaAndDeleteTimeIsNull(String principal);
}
