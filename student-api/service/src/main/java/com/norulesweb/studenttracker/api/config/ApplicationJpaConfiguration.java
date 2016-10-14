package com.norulesweb.studenttracker.api.config;

import com.norulesweb.studenttracker.core.model.common.AuditableDateTimeProvider;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.services.utilities.StudentTrackerUserAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(
		dateTimeProviderRef = "dateTimeProvider",
		auditorAwareRef = "studentTrackerUserAuditorAware"
)
public class ApplicationJpaConfiguration {

	/**
	 * The DateTimeProvider for auditable models
	 */
	@Bean
	public DateTimeProvider dateTimeProvider() {
		return new AuditableDateTimeProvider();
	}

	/**
	 * The SmartFlowUser provider for auditable models
	 */
	@Bean
	public AuditorAware<StudentTrackerUser> studentTrackerUserAuditorAware() {
		return new StudentTrackerUserAuditorAware();
	}
}


