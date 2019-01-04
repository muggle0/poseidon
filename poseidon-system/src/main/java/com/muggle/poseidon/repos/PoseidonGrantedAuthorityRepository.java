package com.muggle.poseidon.repos;

import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
* PoseidonGrantedAuthority的Repository接口
 *
 * @author
 *
 */
@Repository
public interface PoseidonGrantedAuthorityRepository extends CrudRepository<PoseidonGrantedAuthority, String>, JpaSpecificationExecutor<PoseidonGrantedAuthority> {
    PoseidonGrantedAuthority findByIdAndDeleteTimeIsNull(String id);
}
