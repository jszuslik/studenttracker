package com.norulesweb.studenttracker.core.repository.user;

import com.norulesweb.studenttracker.core.common.AppRepository;
import com.norulesweb.studenttracker.core.model.user.AppUser;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppUserRepository extends AppRepository<AppUser, Long> {
	AppUser findByUsername(String username);
	AppUser findById(Long id);

	@Query("select u from AppUser u")
	List<AppUser> getAllAppUsers();
}
