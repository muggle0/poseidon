package com.muggle.poseidon.base.query;

import com.muggle.poseidon.base.BaseQuery;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.handler.query.QuerySqlProcessor;
import org.springframework.security.core.parameters.P;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/5
 **/
public class OaQueryProcessor implements QuerySqlProcessor{


    @Override
    public void afterReturningQuery(ResultBean resultBean) {

    }

    @Override
    public void beforeQuery(BaseQuery baseQuery) {

    }
}
