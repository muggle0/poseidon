package com.muggle.poseidon.base.query;

import com.muggle.poseidon.base.BaseQuery;
import com.muggle.poseidon.base.OAException;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/6
 **/
public class CommonQuery extends BaseQuery {

    private String finalSql;

    @Override
    public void processSql() {
        Map<String, BaseQuery.Operator> operatorMap = this.getOperatorMap();
        StringBuilder builder=new StringBuilder();
        if (operatorMap!=null){
            Iterator<String> iterator = operatorMap.keySet().iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                try {
                    Object field=getFieldValue(next);
                    if ((field instanceof Number)){
                        builder.append(next+operatorMap.get(next).getValue()+field);
                    }else {
                        builder.append(next+operatorMap.get(next).getValue()+"'"+field+"'");
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new OAException("查询参数异常："+next);
                }
            }
        }

        List<String> groupBy = this.getGroupBy();
        if (!CollectionUtils.isEmpty(groupBy)){
            builder.append(" group by");
            for (int i = 0; i < groupBy.size(); i++) {
                if (i==groupBy.size()-1){
                    builder.append(groupBy.get(i));
                }else {
                    builder.append(groupBy.get(i)+",");
                }
            }
        }
        this.finalSql=builder.toString();
    }

    private Object getFieldValue(String next) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(next);
        //打开私有访问
        field.setAccessible(true);
        //获取属性值
        return field.get(this);
    }

    @Override
    public String getFinalSql() {
        return finalSql;
    }

    public void setFinalSql(String finalSql) {
        this.finalSql = finalSql;
    }
}
