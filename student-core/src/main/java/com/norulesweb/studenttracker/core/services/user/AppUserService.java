package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.AppUser;

public interface AppUserService {
	AppUser loadUserByUsername(String username);

	long post(AppUser appUser);

	AppUser get(long id);

	AppUser patch(AppUser appUser);

	boolean delete(long id);
}
