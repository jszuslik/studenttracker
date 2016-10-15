package com.norulesweb.studenttracker.core.security;

import com.norulesweb.studenttracker.core.services.user.StudentTrackerUserDTO;
import com.norulesweb.studenttracker.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentTrackerUserDetailsService implements UserDetailsService {
	@Autowired
	protected UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		StudentTrackerUserDTO userDTO = userService.findUserByUserId(username);

		if (userDTO == null)
			throw new UsernameNotFoundException(username + " not found");

		StudentTrackerUserDetails userDetails = new StudentTrackerUserDetails(userDTO);

		return userDetails;
	}

}