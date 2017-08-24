package com.tgs.tgsit.framework.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.tgs.tgsit.framework.jdbc.RoutingDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by
 */
@Configuration
public class DataSourceConfig {

    private final static Log LOG = LogFactory.getLog(DataSourceConfig.class);

    @Value("${read.jdbc.url}")
    private String readUrl;

    @Value("${read.jdbc.username}")
    private String readUsername;

    @Value("${read.jdbc.password}")
    private String readPassword;

    @Value("${write.jdbc.url}")
    private String writeUrl;

    @Value("${write.jdbc.username}")
    private String writeUsername;

    @Value("${write.jdbc.password}")
    private String writePassword;

    @Bean
    @Primary
    public DataSource dataSource() {
        RoutingDataSource dataSource = new RoutingDataSource();
        dataSource.setDefaultTargetDataSource(writeDataSource());
        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("SLAVE", readDataSource());
        map.put("MASTER", writeDataSource());
        dataSource.setTargetDataSources(map);
        return dataSource;
    }

    /**
     * 此处不要加上@Bean注解，否则会造成springboot自动配置的时候出现多个datasource的情况
     * 所以，不要加@Bean，最终有效的的DataSource就只需要一个通过路由转换的即可
     * @return
     */
    //@Bean(name="readDataSource")
    //@Primary
    public DataSource readDataSource() {
        LOG.info("配置可读数据库");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(readUrl);
        dataSource.setUsername(readUsername);
        dataSource.setPassword(readPassword);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        //最大并发连接数
        dataSource.setMaxActive(20);
        //初始化连接数
        dataSource.setInitialSize(1);
        //最小空闲连接数
        dataSource.setMinIdle(1);
        //获取连接等待超时的时间，毫秒
        dataSource.setMaxWait(60000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(300000);
        //用来检测连接是否有效的sql，要求是一个查询语句,如果不配validationQuery项，则下面三项配置无用
        dataSource.setValidationQuery("SELECT 'x' FROM DUAL");
        //申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(false);
        //打开PSCache，并且指定每个连接上PSCache的大小,mysql下建议关闭
        dataSource.setPoolPreparedStatements(true);
        //要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
        // 在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        //通过connectProperties属性来打开mergeSql功能；慢SQL记录
        Properties properties = new Properties();
        properties.setProperty("druid.stat.mergeSql","true");
        properties.setProperty("druid.stat.slowSqlMillis","5000");
        dataSource.setConnectProperties(properties);
        //合并多个DruiddataSource的监控数据
        dataSource.setUseGlobalDataSourceStat(true);
        try {
            //配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
            dataSource.setFilters("stat,wall,log4j");
        } catch (SQLException e) {
            LOG.error("druid config initialization filter: " + e);
        }
        return dataSource;
    }

    //@Bean(name="writeDataSource")
    //@Primary
    public DataSource writeDataSource() {
        LOG.info("配置可写数据库");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(writeUrl);
        dataSource.setUsername(writeUsername);
        dataSource.setPassword(writePassword);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        //最大并发连接数
        dataSource.setMaxActive(20);
        //初始化连接数
        dataSource.setInitialSize(1);
        //最小空闲连接数
        dataSource.setMinIdle(1);
        //获取连接等待超时的时间，毫秒
        dataSource.setMaxWait(60000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(300000);
        //用来检测连接是否有效的sql，要求是一个查询语句,如果不配validationQuery项，则下面三项配置无用
        dataSource.setValidationQuery("SELECT 'x' FROM DUAL");
        //申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(false);
        //打开PSCache，并且指定每个连接上PSCache的大小,mysql下建议关闭
        dataSource.setPoolPreparedStatements(true);
        //要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
        // 在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        //通过connectProperties属性来打开mergeSql功能；慢SQL记录
        Properties properties = new Properties();
        properties.setProperty("druid.stat.mergeSql","true");
        properties.setProperty("druid.stat.slowSqlMillis","5000");
        dataSource.setConnectProperties(properties);
        //合并多个DruiddataSource的监控数据
        dataSource.setUseGlobalDataSourceStat(true);
        try {
            //配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
            dataSource.setFilters("stat,wall,log4j");
        } catch (SQLException e) {
            LOG.error("druid config initialization filter: " + e);
        }
        return dataSource;
    }



}
