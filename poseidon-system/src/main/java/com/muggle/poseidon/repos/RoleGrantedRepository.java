package com.muggle.poseidon.repos;

import com.muggle.poseidon.model.RoleGranted;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
* RoleGranted的Repository接口
 *
 * @author
 *
 */
@Repository
public interface RoleGrantedRepository extends CrudRepository<RoleGranted, String>, JpaSpecificationExecutor<RoleGranted> {

}
