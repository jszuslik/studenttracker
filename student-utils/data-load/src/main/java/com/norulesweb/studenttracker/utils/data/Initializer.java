package com.norulesweb.studenttracker.utils.data;

import com.norulesweb.studenttracker.core.model.user.Role;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerRole;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.repository.user.RoleRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerRolesRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerSystemRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerUserRepository;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerSystemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	protected StudentTrackerRolesRepository studentTrackerRolesRepository;

	@Autowired
	protected RoleRepository roleRepository;


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

		List<StudentTrackerUser> users = studentTrackerUserRepository.findByUserName(userName);

		if (users == null) {
			StudentTrackerUser user = new StudentTrackerUser();
			user = new StudentTrackerUser();
			user.setUserName(userName);
			user.setPassword(userPassword);

			user = studentTrackerUserRepository.save(user);

			for(String[] role : roles) {
				Role userRole = roleRepository.findByRoleCode(role[0]);
				StudentTrackerRole newRole = new StudentTrackerRole();
				newRole.setRoleCode(userRole.getRoleCode());
				newRole.setRoleDescription(userRole.getRoleDescription());
				newRole.setStudentTrackerUser(user);
				newRole = studentTrackerRolesRepository.save(newRole);
				user.addRole(newRole);
			}
			studentTrackerUserRepository.save(user);
		}
	}

//	public void setup() {
//		// Initialize user lookup for auditing
//		studentTrackerUserAuditorAwareLocal.getCurrentAuditor();
//	}



}
