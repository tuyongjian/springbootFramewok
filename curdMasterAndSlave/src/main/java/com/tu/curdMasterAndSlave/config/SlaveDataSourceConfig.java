package com.tu.curdMasterAndSlave.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @Auther: tuyongjian
 * @Date: 2020/1/8 10:40
 * @Description:
 */
@Configuration
@MapperScan(basePackages = "com.tu.curdMasterAndSlave.dao", sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveDataSourceConfig {

    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }


    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("slave") DruidDataSource slave) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //数据源
        factoryBean.setDataSource(slave);
        //mapper路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:mybatis/mapper/*.xml");
        factoryBean.setMapperLocations(resources);
        return factoryBean.getObject();
    }

    @Bean(name = "slaveSqlSessionTemplate")
    public SqlSessionTemplate slaveSqlSessionTemplate(@Qualifier("slaveSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
