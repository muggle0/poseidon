package com.muggle.poseidon.repos;

import com.muggle.poseidon.model.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoseidonRoleRepository extends CrudRepository<Role, String>, JpaSpecificationExecutor<Role> {


}
