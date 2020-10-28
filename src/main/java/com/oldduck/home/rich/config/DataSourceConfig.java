package com.oldduck.home.rich.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author ：ex-caihh
 * @description：datasource
 * @date ：Created in 2020/10/27 14:31
 */
@Configuration
@MapperScan(basePackages = "com.oldduck.home.rich.dao")
public class DataSourceConfig {

    private static final String CONFIG_PRIX = "spring.datasource.";
    private static final String XML_SOURCE_FILE_PATH = "classpath:mapper/*";

    @Value("${" + CONFIG_PRIX + "driver-class-name}")
    String driverClassName;
    @Value("${" + CONFIG_PRIX + "url}")
    String url;
    @Value("${" + CONFIG_PRIX + "username}")
    String username;
    @Value("${" + CONFIG_PRIX + "password}")
    String password;
    @Value("${" + CONFIG_PRIX + "dbcp2.min-idle}")
    Integer maxPoolSize;
    @Value("${" + CONFIG_PRIX + "dbcp2.initial-size}")
    Integer initialPoolSize;
    @Value("${" + CONFIG_PRIX + "dbcp2.max-idle}")
    Integer minPoolSize;


    /**
     * 生成数据源，@Primary注解声明为默认数据源
     *
     * @return
     */
    @Bean(name = "dataSoure")
    @Primary
    public DataSource primaryDataSource() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        //连接池配置
        dataSource.setMaxActive(maxPoolSize);
        dataSource.setMinIdle(minPoolSize);
        dataSource.setInitialSize(initialPoolSize);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setValidationQuery("select sysdate from dual");

        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        dataSource.setFilters("stat");
        return dataSource;
    }

    /**
     * 创建sqlSessionFactory
     *
     * @param datasource
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("dataSoure") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(XML_SOURCE_FILE_PATH));
        return bean.getObject();
    }

    /**
     * 配置事务管理
     *
     * @param datasource
     * @return
     */
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("dataSoure") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
