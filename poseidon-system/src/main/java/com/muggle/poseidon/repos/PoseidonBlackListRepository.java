package com.muggle.poseidon.repos;

import com.muggle.poseidon.entity.PoseidonBlackList;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
* PoseidonBlackList的Repository接口
 *
 * @author
 *
 */
@Repository
public interface PoseidonBlackListRepository extends CrudRepository<PoseidonBlackList, String>, JpaSpecificationExecutor<PoseidonBlackList> {

}
