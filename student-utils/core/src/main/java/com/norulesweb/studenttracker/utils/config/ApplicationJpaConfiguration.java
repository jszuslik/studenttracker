package com.norulesweb.studenttracker.utils.config;

import com.norulesweb.studenttracker.core.model.common.AuditableDateTimeProvider;
import com.norulesweb.studenttracker.core.services.utilities.StudentTrackerUserAuditorAwareLocal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(
		dateTimeProviderRef = "dateTimeProvider",
		auditorAwareRef = "studentTrackerUserAuditorAwareLocal"
)
public class ApplicationJpaConfiguration {

	/**
	 * The StudentTrackerUser ID that the utility will run under (for auditing purposes)
	 */
	@Value("${utils.user}")
	protected String utilitiesUserName;

	/**
	 * The DateTimeProvider for auditable models
	 */
	@Bean
	public DateTimeProvider dateTimeProvider() {
		return new AuditableDateTimeProvider();
	}

	/**
	 * The StudentTrackerUser provider for auditable models
	 */
	@Bean
	public StudentTrackerUserAuditorAwareLocal studentTrackerUserAuditorAwareLocal() {
		StudentTrackerUserAuditorAwareLocal auditor = new StudentTrackerUserAuditorAwareLocal(utilitiesUserName);
		return auditor;
	}
}


