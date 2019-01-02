package com.muggle.poseidon.repos;

import com.muggle.poseidon.model.UserRole;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
* UserRole的Repository接口
 *
 * @author
 *
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, String>, JpaSpecificationExecutor<UserRole> {
    List<UserRole> findByRoleId(String roleId);
}
