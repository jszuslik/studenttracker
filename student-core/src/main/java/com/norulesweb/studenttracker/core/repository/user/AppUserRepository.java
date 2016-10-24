package com.norulesweb.studenttracker.core.repository.user;

import com.norulesweb.studenttracker.core.common.AppRepository;
import com.norulesweb.studenttracker.core.model.user.AppUser;

public interface AppUserRepository extends AppRepository<AppUser, Long> {
	AppUser findByUsername(String username);
	AppUser findById(Long id);
}
