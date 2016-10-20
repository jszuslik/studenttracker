package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerRoles;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerRolesRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerSystemRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerUserRepository;
import com.norulesweb.studenttracker.core.services.utilities.UserLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	protected LoggedInChecker loggedInChecker;

	@Autowired
	protected StudentTrackerRolesRepository studentTrackerRolesRepository;

	@Autowired
	protected StudentTrackerUserRepository studentTrackerUserRepository;

	@Autowired
	protected StudentTrackerSystemRepository studentTrackerSystemRepository;

	@Autowired
	protected UserLookup userLookup;

	@Override
	public StudentTrackerUserDTO createStudentTrackerUser(StudentTrackerUserDTO user, StudentTrackerSystem studentTrackerSystem) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		Set<StudentTrackerRoles> roles = user.get

		StudentTrackerUser studentTrackerUser = new StudentTrackerUser();
		studentTrackerUser.setUserName(user.getUserName());
		studentTrackerUser.setPassword(passwordEncoder.encode(user.getPassword()));

		studentTrackerUser.setStudentTrackerSystem(studentTrackerSystem);

		StudentTrackerUser savedUser = studentTrackerUserRepository.save(studentTrackerUser);

		studentTrackerUserRepository.flushAndRefresh(savedUser);

		return new StudentTrackerUserDTO(savedUser);
	}

	@Override
	@Transactional(readOnly = true)
	public StudentTrackerUserDTO findUserByUserName(String userName) {
		List<StudentTrackerUser> users = studentTrackerUserRepository.findByUserName(userName);

		if (users.isEmpty())
			return null;
		else
			return new StudentTrackerUserDTO(users.get(0));
	}

	@Override
	public StudentTrackerSystemDTO saveStudentTrackerSystem(StudentTrackerSystemDTO system) {
		StudentTrackerSystem updated = studentTrackerSystemRepository.save(system.buildModel());

		studentTrackerSystemRepository.flushAndRefresh(updated);

		return new StudentTrackerSystemDTO(updated);
	}

	@Override
	public StudentTrackerSystem getStudentTrackerSystemForCurrentUser() {
		StudentTrackerUser user = userLookup.getCurrentUser();

		if (user != null)
			return user.getStudentTrackerSystem();
		else
			return null;
	}

	@Override
	public Boolean isCurrentUserLoggedIn() {
		return loggedInChecker.getLoggedInUser() != null;
	}
}
