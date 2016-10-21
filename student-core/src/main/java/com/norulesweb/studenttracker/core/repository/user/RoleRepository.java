package com.norulesweb.studenttracker.core.repository.user;

import com.norulesweb.studenttracker.core.common.StudentTrackerRepository;
import com.norulesweb.studenttracker.core.model.user.Role;

public interface RoleRepository extends StudentTrackerRepository<Role, Long> {
	Role findByRoleCode(String roleCode);
}
