package com.yvan.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@SpringBootApplication
public class SecurityApplication {


	@Bean
	@Primary
	@ConfigurationProperties(prefix="datasource.mysql")
	public DataSource dataSourceMysql() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dataSourceMysql())
				.packages("com.yvan.**.entity")
				.persistenceUnit("mysql")
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
}
