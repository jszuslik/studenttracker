package com.norulesweb.studenttracker.utils.data;

import com.norulesweb.studenttracker.core.model.user.Role;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;
import com.norulesweb.studenttracker.core.repository.user.RoleRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerSystemRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerUserRepository;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerRoleDTO;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerSystemDTO;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerUserDTO;
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

	@Value("${initialize.user.email}")
	protected String userEmail;

	@Value("${initialize.platform.name}")
	protected String platformName;

	@Value("${initialize.platform.description}")
	protected String platformDescription;

	@Autowired
	protected StudentTrackerSystemRepository studentTrackerSystemRepository;

	@Autowired
	protected StudentTrackerUserRepository studentTrackerUserRepository;

	@Autowired
	protected UserService userService;

	@Autowired
	protected RoleRepository roleRepository;

	@Autowired
	protected StudentTrackerUserAuditorAwareLocal studentTrackerUserAuditorAwareLocal;

	public void initializePlatform() {

		String[][] roles = {
				{"ROLE_ADMIN", "System Administrator"},
				{"ROLE_TEACHER", "School Teacher"},
				{"ROLE_STUDENT", "School Student"},
				{"ROLE_PARENT", "Students Parent"}
		};

		for(String[] role : roles){
			Role newRole = new Role();
			newRole.setRoleCode(role[0]);
			newRole.setRoleDescription(role[1]);
			roleRepository.save(newRole);
		}

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

		StudentTrackerUserDTO studentTrackerUserDTO;
		if (userService.findUserByUserName(userName) == null) {
			studentTrackerUserDTO = new StudentTrackerUserDTO();
			studentTrackerUserDTO.setUserName(userName);
			studentTrackerUserDTO.setPassword(userPassword);
			studentTrackerUserDTO.setUserEmail(userEmail);
			for(String[] role : roles) {
				Role userRole = roleRepository.findByRoleCode(role[0]);
				StudentTrackerRoleDTO roleDTO = new StudentTrackerRoleDTO();
				roleDTO.setRoleCode(userRole.getRoleCode());
				roleDTO.setRoleDescription(userRole.getRoleDescription());
				studentTrackerUserDTO.addRole(roleDTO);
			}

			userService.createStudentTrackerUser(studentTrackerUserDTO, system);
		}
	}

//	public void setup() {
//		// Initialize user lookup for auditing
//		studentTrackerUserAuditorAwareLocal.getCurrentAuditor();
//	}



}
