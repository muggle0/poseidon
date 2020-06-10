package com.muggle.poseidon.oa.handler;

import com.muggle.poseidon.base.BaseQuery;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.handler.query.QuerySqlProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/8
 **/
@Component
public class TestQueryProcessor implements QuerySqlProcessor {
    @Override
    public void afterReturningQuery(ResultBean resultBean) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void beforeQuery(BaseQuery baseQuery) {
    }
}
