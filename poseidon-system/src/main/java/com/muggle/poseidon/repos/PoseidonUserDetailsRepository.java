package com.muggle.poseidon.repos;

import com.muggle.poseidon.model.PoseidonUserDetail;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoseidonUserDetailsRepository extends CrudRepository<PoseidonUserDetail, String>, JpaSpecificationExecutor<PoseidonUserDetail> {
     PoseidonUserDetail findByUsernameAnddAndDeleteTimeIsNull(String username);
}