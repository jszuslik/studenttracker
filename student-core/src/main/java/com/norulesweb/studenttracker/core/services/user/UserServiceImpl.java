package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerSystemRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerUserRepository;
import com.norulesweb.studenttracker.core.services.utilities.UserLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	protected StudentTrackerUserRepository studentTrackerUserRepository;

	@Autowired
	protected StudentTrackerSystemRepository studentTrackerSystemRepository;

	@Autowired
	protected UserLookup userLookup;

	@Override
	public StudentTrackerUserDTO createStudentTrackerUser(String userId, String plaintextPassword, Long studentTrackerSystemId) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		StudentTrackerUser studentTrackerUser = new StudentTrackerUser();
		studentTrackerUser.setUserId(userId);
		studentTrackerUser.setPassword(passwordEncoder.encode(plaintextPassword));

		StudentTrackerSystem studentTrackerSystem = new StudentTrackerSystem();
		studentTrackerSystem.setId(studentTrackerSystemId);
		studentTrackerUser.setStudentTrackerSystem(studentTrackerSystem);

		StudentTrackerUser savedUser = studentTrackerUserRepository.save(studentTrackerUser);

		studentTrackerUserRepository.flushAndRefresh(savedUser);

		return new StudentTrackerUserDTO(savedUser);
	}

	@Override
	@Transactional(readOnly = true)
	public StudentTrackerUserDTO findUserByUserId(String userId) {
		List<StudentTrackerUser> users = studentTrackerUserRepository.findByUserId(userId);

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
}
