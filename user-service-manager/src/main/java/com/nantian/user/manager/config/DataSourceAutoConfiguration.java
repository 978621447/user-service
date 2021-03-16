package com.nantian.user.manager.config;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author WangJinYi 2021/3/6
 */
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceAutoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAutoConfiguration.class);

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource customDataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(CustomDruidDataSource.class).build();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(
            DataSource customDataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(customDataSource);
        return manager;
    }

    private static class CustomDruidDataSource extends DruidDataSource {
        @Override
        public String getUsername(){
            String encPass = super.getUsername();
            String decPass = null;
            try {
                decPass = ConfigTools.decrypt(encPass);
            } catch (Exception e) {
                LOGGER.error("用户名解密异常", e);
            }
            return decPass;
        }

        @Override
        public String getPassword() {
            String encPass = super.getPassword();
            String decPass = null;
            try {
                decPass = ConfigTools.decrypt(encPass);
            } catch (Exception e) {
                LOGGER.error("密码解密异常", e);
            }
            return decPass;
        }
    }

    public static void main(String[] args) throws Exception {
        String encrypt = ConfigTools.encrypt("userx");
        System.out.println(encrypt);
    }
}
