package com.xjliang.bootlaunch.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration
@MapperScan(basePackages = "com.xjliang.bootlaunch.generator.testdb2",
    sqlSessionTemplateRef = "secondarySqlSessionTemplate")
public class SecondaryDataSourceJTAConfig {

    @Bean("secondaryDataSource")
    @ConfigurationProperties(prefix = "secondarydb")
    @Primary
    public DataSource secondaryDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean("secondarySqlSessionFactory")
    @Primary
    public SqlSessionFactory secondarySqlSessionFactory(
        @Qualifier("secondaryDataSource") DataSource dataSource)
        throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        bean.setTypeAliasesPackage("com.xjliang.bootlaunch.generator.testdb2");
        return bean.getObject();
    }

    @Bean("secondarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate secondarySqlSessionTemplate(
        @Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory)
        throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
