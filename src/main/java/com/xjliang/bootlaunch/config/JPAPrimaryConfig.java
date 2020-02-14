package com.xjliang.bootlaunch.config;

import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactoryPrimary",
    transactionManagerRef = "transactionManagerPrimary",
    basePackages = {"com.xjliang.bootlaunch.jpa.testdb"}) //设置Repository所在位置
public class JPAPrimaryConfig {

    @Resource(name = "primaryDataSource")
    private DataSource primaryDataSource;

    @Resource
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;

    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(
        EntityManagerFactoryBuilder builder) {

        Map<String, Object> vendorProperties = hibernateProperties
            .determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());

        return builder
            .dataSource(primaryDataSource)
            .properties(vendorProperties)
            .packages("com.xjliang.bootlaunch.jpa.testdb") //设置实体类所在位置
            .persistenceUnit("primaryPersistenceUnit")
            .build();
    }

    // Deprecated
    //    private Map getVendorProperties() {
    //        return jpaProperties.getHibernateProperties(new HibernateSettings());
    //    }

    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManagerPrimary(
        EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}
