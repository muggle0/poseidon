package com.muggle.poseidon.utils.query;

import java.util.List;

/**
 * @program: activiti
 * @description: 查询类
 * @author: muggle
 * @create: 2019-01-27 10:38
 **/

public class QueryManager {
    private List<Query> queries;
    private boolean distinct;
    /** 数据分页开始行 */
    private Integer startRow;
    /** 每次取多少行数据 */
    private Integer rowSize;
}
