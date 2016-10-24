package com.norulesweb.studenttracker.api.security.service;

import com.norulesweb.studenttracker.api.security.model.SpringSecurityUser;
import com.norulesweb.studenttracker.core.services.user.AppUserService;
import com.norulesweb.studenttracker.core.model.user.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserService appUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = this.appUserService.loadUserByUsername(username);

		if (appUser == null) {
			throw new UsernameNotFoundException(String.format("No appUser found with username '%s'.", username));
		} else {
			return new SpringSecurityUser(
					                             appUser.getId(),
					                             appUser.getUsername(),
					                             appUser.getPassword(),
					                             null,
					                             null,
					                             AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.getAuthorities())
			);
		}
	}

}
