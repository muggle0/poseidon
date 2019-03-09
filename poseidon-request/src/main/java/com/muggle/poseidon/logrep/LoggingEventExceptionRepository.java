package com.muggle.poseidon.logrep;

import com.muggle.poseidon.entity.LoggingEventException;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
* LoggingEventException的Repository接口
 *
 * @author
 *
 */
@Repository
public interface LoggingEventExceptionRepository extends CrudRepository<LoggingEventException, String>, JpaSpecificationExecutor<LoggingEventException> {

}
