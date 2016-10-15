package com.norulesweb.studenttracker.core.services.utilities;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Used for local utilities / workers to inject a StudentTrackerUser into auditor-aware JPA repositories.
 *
 * This is a GLOBAL StudentTrackerUser, not thread-local.  It should be set once during initialization of
 * the local application.
 */
@Component
public class StudentTrackerUserAuditorAwareLocal implements AuditorAware<StudentTrackerUser> {

	@Autowired
	protected StudentTrackerUserRepository studentTrackerUserRepository;

	private static String studentTrackerUserId;

	private static StudentTrackerUser studentTrackerUser;

	public void setStudentTrackerUserId(String userid) {
		studentTrackerUserId = userid;
	}

	public StudentTrackerUserAuditorAwareLocal() { }

	public StudentTrackerUserAuditorAwareLocal(String userId) {
		setStudentTrackerUserId(userId);
	}

	@Override
	public StudentTrackerUser getCurrentAuditor() {
		if (studentTrackerUser == null) {
			studentTrackerUser = studentTrackerUserRepository.findByUserId(studentTrackerUserId).get(0);
		}
		return studentTrackerUser;
	}
}

