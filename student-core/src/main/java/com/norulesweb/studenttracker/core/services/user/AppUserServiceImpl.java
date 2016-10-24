package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.AppUser;
import com.norulesweb.studenttracker.core.repository.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "appUserService")
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	protected AppUserRepository appUserRepository;


	@Override
	@Transactional
	public AppUser loadUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Transactional
	@Override
	public long post(AppUser appUser) {
		appUser = appUserRepository.findByUsername(appUser.getUsername());

		return appUser.getId();
	}

	@Transactional
	@Override
	public AppUser get(long id) {
		AppUser appUser = appUserRepository.findById(id);
		return appUser;
	}

	@Transactional
	@Override
	public AppUser patch(AppUser appUser) {
		appUser = appUserRepository.save(appUser);
		return appUser;
	}

	@Transactional
	@Override
	public boolean delete(long id) {
		AppUser appUser = appUserRepository.findById(id);
		appUserRepository.delete(appUser);
		return true;
	}
}
