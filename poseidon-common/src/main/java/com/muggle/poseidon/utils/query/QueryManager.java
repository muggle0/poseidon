package com.muggle.poseidon.utils.query;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @program: activiti
 * @description: 查询类
 * @author: muggle
 * @create: 2019-01-27 10:38
 **/
@Data
public class QueryManager<T> {
    private List<Query> queries;
    private boolean distinct;
    /** 数据分页开始行 */
    private Integer startRow;
    /** 每次取多少行数据 */
    private Integer rowSize;

    public Specification<T> getSpec(){
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                Predicate predicate = builder.isNull(root.get("deleteTime"));
                queries.forEach(item->{
//
                    if (item.getQueryType())
                });
                return null;
            }
        };
    }
}
