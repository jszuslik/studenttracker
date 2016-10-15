package com.norulesweb.studenttracker.utils.config;

import com.norulesweb.studenttracker.core.common.StudentTrackerRepositoryFactoryBean;
import com.norulesweb.studenttracker.core.services.utilities.StudentTrackerUserAuditorAwareLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Basic configuration for a command-line utility.  This pulls in the core + eventing pieces and
 * sets up the JPA repositories.
 */
@Configuration
@PropertySources({
		@PropertySource(value = "classpath:spring-data-application.properties"),
		@PropertySource(value = "file:spring-data-application.runtime.properties", ignoreResourceNotFound = true)
})
@EnableAutoConfiguration(exclude={
		JmsAutoConfiguration.class
})
/* Define the packages to scan */
@ComponentScan(basePackages = {
		"com.norulesweb.studenttracker.utils",
		"com.norulesweb.studenttracker.core"
})
/* Set up JPA repositories */
@EnableTransactionManagement
@EnableJpaRepositories(
		repositoryFactoryBeanClass = StudentTrackerRepositoryFactoryBean.class,
		basePackages = { "com.norulesweb.studenttracker.core.repository" }
)
@EntityScan(basePackages = { "com.norulesweb.studenttracker.core" })
public class CommandLineUtilityConfiguration {

	@Autowired
	StudentTrackerUserAuditorAwareLocal studentTrackerUserAuditorAwareLocal;

	/**
	 * Load the user for auditing.  This needs to happen separate from any
	 * other transaction, and only needs to happen once per application run.
	 */
	public void setupAuditing() {
		studentTrackerUserAuditorAwareLocal.getCurrentAuditor();
	}
}


