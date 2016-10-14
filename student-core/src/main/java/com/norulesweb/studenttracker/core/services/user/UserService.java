package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;

public interface UserService {
	StudentTrackerUserDTO createStudentTrackerUser(String userId, String plaintextPassword, Long StudentTrackerSystemId);

	StudentTrackerUserDTO findUserByUserId(String userId);

	StudentTrackerSystemDTO saveStudentTrackerSystem(StudentTrackerSystemDTO system);

	StudentTrackerSystem getStudentTrackerSystemForCurrentUser();

}
