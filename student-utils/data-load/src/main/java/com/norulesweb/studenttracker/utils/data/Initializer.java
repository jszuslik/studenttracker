package com.norulesweb.studenttracker.utils.data;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerSystemRepository;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerSystemDTO;
import com.norulesweb.studenttracker.core.services.user.UserService;
import com.norulesweb.studenttracker.core.services.utilities.StudentTrackerUserAuditorAwareLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PropertySources({
		@PropertySource(value = "classpath:initializer.properties")
		, @PropertySource(value = "file:initializer.runtime.properties", ignoreResourceNotFound = true)
})
@Transactional
public class Initializer {

	private static final Logger log = LoggerFactory.getLogger(Initializer.class);

	@Value("${initialize.user.name}")
	protected String userName;

	@Value("${initialize.user.password}")
	protected String userPassword;

	@Value("${initialize.platform.name}")
	protected String platformName;

	@Value("${initialize.platform.description}")
	protected String platformDescription;

	@Autowired
	protected StudentTrackerSystemRepository studentTrackerSystemRepository;

	@Autowired
	protected UserService userService;

	@Autowired
	protected StudentTrackerUserAuditorAwareLocal studentTrackerUserAuditorAwareLocal;

	public void initializePlatform() {

		StudentTrackerSystemDTO studentTrackerSystemDTO;
		StudentTrackerSystem system = studentTrackerSystemRepository.findByName(platformName);
		if (system == null) {
			system = new StudentTrackerSystem();
			system.setName(platformName);
			system.setDescription(platformDescription);

			studentTrackerSystemRepository.save(system);
		} else {
			studentTrackerSystemDTO = new StudentTrackerSystemDTO(system);
		}

		if (userService.findUserByUserName(userName) == null) {
			// Create a user
			userService.createStudentTrackerUser(userName, userPassword, system);
		}
	}

//	public void setup() {
//		// Initialize user lookup for auditing
//		studentTrackerUserAuditorAwareLocal.getCurrentAuditor();
//	}



}
