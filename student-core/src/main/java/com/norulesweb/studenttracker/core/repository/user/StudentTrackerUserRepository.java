package com.norulesweb.studenttracker.core.repository.user;

import com.norulesweb.studenttracker.core.common.StudentTrackerRepository;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;

import java.util.List;

public interface StudentTrackerUserRepository extends StudentTrackerRepository<StudentTrackerUser, Long> {
	public List<StudentTrackerUser> findByUserName(String userName);
}
