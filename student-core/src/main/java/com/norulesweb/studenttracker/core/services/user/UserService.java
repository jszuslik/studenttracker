package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;

public interface UserService {
	StudentTrackerUserDTO createStudentTrackerUser(StudentTrackerUserDTO user, StudentTrackerSystem studentTrackerSystem);

	StudentTrackerUserDTO findUserByUserName(String userName);

	StudentTrackerSystemDTO saveStudentTrackerSystem(StudentTrackerSystemDTO system);

	StudentTrackerSystem getStudentTrackerSystemForCurrentUser();

	Boolean isCurrentUserLoggedIn();

}
