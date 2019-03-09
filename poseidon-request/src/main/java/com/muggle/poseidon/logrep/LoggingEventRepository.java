package com.muggle.poseidon.logrep;

import com.muggle.poseidon.entity.LoggingEvent;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
* LoggingEvent的Repository接口
 *
 * @author
 *
 */
@Repository
public interface LoggingEventRepository extends CrudRepository<LoggingEvent, String>, JpaSpecificationExecutor<LoggingEvent> {

}
