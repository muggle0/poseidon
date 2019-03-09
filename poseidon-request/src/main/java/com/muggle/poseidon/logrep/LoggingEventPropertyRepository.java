package com.muggle.poseidon.logrep;

import com.muggle.poseidon.entity.LoggingEventProperty;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
* LoggingEventProperty的Repository接口
 *
 * @author
 *
 */
@Repository
public interface LoggingEventPropertyRepository extends CrudRepository<LoggingEventProperty, String>, JpaSpecificationExecutor<LoggingEventProperty> {

}
