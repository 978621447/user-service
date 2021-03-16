package com.nantian.user.manager.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author WangJinYi 2021/3/6
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfiguration {

    @Bean
    @Primary
    public SqlSessionFactoryBean createSqlSessionFactory(@Qualifier("customDataSource") DataSource customDataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 配置数据源
        sqlSessionFactoryBean.setDataSource(customDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.nantian.user.domain");
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*Mapper.xml"));
        return sqlSessionFactoryBean;
    }

}
