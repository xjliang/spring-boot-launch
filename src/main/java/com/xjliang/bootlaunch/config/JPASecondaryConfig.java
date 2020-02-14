package com.xjliang.bootlaunch.config;

import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactorySecondary",
    transactionManagerRef = "transactionManagerSecondary",
    basePackages = {"com.xjliang.bootlaunch.jpa.testdb2"}) //设置Repository所在位置
public class JPASecondaryConfig {

    @Resource(name = "secondaryDataSource")
    private DataSource secondaryDataSource;

    @Resource
    private JpaProperties jpaProperties;

    @Resource
    private HibernateProperties hibernateProperties;

    @Bean(name = "entityManagerSecondary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactorySecondary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(
        EntityManagerFactoryBuilder builder) {

        Map<String, Object> vendorProperties = hibernateProperties
            .determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());

        return builder
            .dataSource(secondaryDataSource)
            .properties(vendorProperties)
            .packages("com.xjliang.bootlaunch.jpa.testdb2") //设置实体类所在位置
            .persistenceUnit("secondaryPersistenceUnit")
            .build();
    }

    // Deprecated
    //    private Map getVendorProperties() {
    //        return jpaProperties.getHibernateProperties(new HibernateSettings());
    //    }

    @Bean(name = "transactionManagerSecondary")
    public PlatformTransactionManager transactionManagerSecondary(
        EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
    }
}
