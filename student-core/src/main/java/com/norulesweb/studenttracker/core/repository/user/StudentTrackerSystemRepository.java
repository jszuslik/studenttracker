package com.norulesweb.studenttracker.core.repository.user;

import com.norulesweb.studenttracker.core.common.StudentTrackerRepository;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;

public interface StudentTrackerSystemRepository extends StudentTrackerRepository<StudentTrackerSystem, Long> {
	public StudentTrackerSystem findByName(String name);
}
