package com.norulesweb.studenttracker.api;

import com.norulesweb.studenttracker.core.common.StudentTrackerRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@PropertySources({
	@PropertySource(value = "classpath:spring-data-application.properties"),
	@PropertySource(value = "classpath:spring-data-application.runtime.properties", ignoreResourceNotFound = true)
})
@ComponentScan(
		basePackages = { "com.norulesweb.studenttracker.core", "com.norulesweb.studenttracker.api"}
)
@EnableTransactionManagement
// @ImportResource("classpath:event-integration.xml")
@EnableJpaRepositories(
		repositoryFactoryBeanClass = StudentTrackerRepositoryFactoryBean.class,
		basePackages = { "com.norulesweb.studenttracker.core.repository" }
)
@EntityScan(basePackages = { "com.norulesweb.studenttracker.core" })

public class Application extends SpringBootServletInitializer {
}
