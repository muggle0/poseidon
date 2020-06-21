package com.muggle.poseidon.config;

import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/18
 **/
public class shardingconfig {




    /**
     * address表分片策略
     * @return
     */
    private TableRuleConfiguration addressRuleConfig() {
        // 配置address表规则
        TableRuleConfiguration tableRuleConfig = new TableRuleConfiguration();
        tableRuleConfig.setLogicTable("t_address");
        tableRuleConfig.setActualDataNodes("ds${0..1}.t_address");
        tableRuleConfig.setKeyGeneratorColumnName("id");
        // 配置分库 + 分表策略
        tableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("lit", "ds${lit % 2}"));
        return tableRuleConfig;
    }
}
