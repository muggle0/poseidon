package com.muggle.poseidon.utils.query;

import lombok.Data;

/**
 * @program: activiti
 * @description: 查询类封装
 * @author: muggle
 * @create: 2019-01-27 09:56
 **/
@Data
public class Query {
    private String field;
    private QueryType queryType;
    private String value;
}
