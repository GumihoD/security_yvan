package com.yvan.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.yvan.security.repository",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "transactionManagerMysql"
)
public class JpaRepositoryMysqlConfig {

    @Autowired
    @Qualifier(value = "mysqlEntityManagerFactory")
    private EntityManagerFactory entityManagerFactoryMysql;

    @Bean
    public PlatformTransactionManager transactionManagerMysql() {
        return new JpaTransactionManager(entityManagerFactoryMysql);
    }
}
