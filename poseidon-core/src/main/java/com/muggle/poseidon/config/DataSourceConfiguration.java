package com.muggle.poseidon.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
//@ConditionalOnProperty(prefix = "poseidon.mybatis",name = "support",havingValue = "normal" )
@SuppressWarnings("all")
@MapperScan(basePackages = "com.muggle.poseidon.oa.mapper")
@Order(1)
public class DataSourceConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);
    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUsername;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    public DataSourceConfiguration() {
        log.info("数据源配置》》》》》》》》》》》》》》》》》》》");
    }

    /**
     * 生成与spring-dao.xml对应的bean dataSource
     *
     * @return
     * @throws
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() throws SQLException {
        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        DruidDataSource dataSource0 = createDb0();
        dataSourceMap.put("ds0", dataSource0);
        TableRuleConfiguration tableRuleConfig = userRuleConfig();
        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(tableRuleConfig);
        shardingRuleConfig.getTableRuleConfigs().add(userRuleConfig());
        Properties p = new Properties();
        p.setProperty("sql.show",Boolean.TRUE.toString());
        // 获取数据源对象
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap(), p);
        return dataSource;
    }

    private DruidDataSource createDb0() {
        // 配置第二个数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        // 每个分区最大的连接数
        dataSource.setMaxActive(20);
        // 每个分区最小的连接数
        dataSource.setMinIdle(5);
        return dataSource;
    }

    @Bean
    public Filter statFilter(){
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(5000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }


    /**
     * user表分片策略
     * @return
     */
    private TableRuleConfiguration userRuleConfig() {
        // 配置user表规则
        TableRuleConfiguration tableRuleConfig = new TableRuleConfiguration();
        tableRuleConfig.setLogicTable("t_user");
        tableRuleConfig.setActualDataNodes("ds${0..1}.t_user${0..1}");
        tableRuleConfig.setKeyGeneratorColumnName("id");
        // 配置分库 + 分表策略
        tableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("city_id", "ds${city_id % 2}"));
        tableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("sex", "t_user${sex % 2}"));
        return tableRuleConfig;
    }

}
