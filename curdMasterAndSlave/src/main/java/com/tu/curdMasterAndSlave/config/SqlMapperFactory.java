package com.tu.curdMasterAndSlave.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SqlMapperFactory implements ApplicationContextAware {
    private static Map<String, Object> mapperCache = new ConcurrentHashMap<>();

    @Qualifier("masterSqlSessionTemplate")
    private static SqlSessionTemplate masterSqlSessionTemplate;

    @Qualifier("slaveSqlSessionTemplate")
    private static SqlSessionTemplate slaveSqlSessionTemplate;

    public static <T> T buildMaster(Class<T> mapperClass) {
        return getMapper(masterSqlSessionTemplate, mapperClass, "masterSqlSessionTemplate");
    }

    public static <T> T buildSlave(Class<T> mapperClass) {
        return getMapper(slaveSqlSessionTemplate, mapperClass, "slaveSqlSessionTemplate");
    }


    private static <T> T getMapper(SqlSessionTemplate template, Class<T> mapperClass, String sqlSessionTempleteName) {
        String name = mapperClass.getName();
        Object o = mapperCache.get(name + "_" + sqlSessionTempleteName);
        if (o != null) {
            return mapperClass.cast(o);
        }else {
            Configuration configuration = template.getConfiguration();
            if(configuration.hasMapper(mapperClass)){
                return template.getMapper(mapperClass);
            }else {
                configuration.addMapper(mapperClass);
                T mapper = configuration.getMapper(mapperClass, template);
                mapperCache.put(name + "_" + sqlSessionTempleteName, mapper);
                return mapper;
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, SqlSessionTemplate> sstMap = applicationContext.getBeansOfType(SqlSessionTemplate.class);
        masterSqlSessionTemplate = sstMap.get("masterSqlSessionTemplate");
        slaveSqlSessionTemplate = sstMap.get("slaveSqlSessionTemplate");
    }
}
