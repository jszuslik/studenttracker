package com.norulesweb.studenttracker.core.security;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Basic Spring Security implementation of {@link org.springframework.security.core.userdetails.UserDetails}
 */
public class StudentTrackerUserDetails implements UserDetails {
	
	private static final long serialVersionUID = -4958723639132118472L;
	
	protected String password;
	
	protected String username;
	
	protected boolean enabled;
	
	protected StudentTrackerUser studentTrackerUser;
	
	public StudentTrackerUserDetails(StudentTrackerUserDTO userDTO) {
		username = userDTO.getUserId();
		password = userDTO.getPassword();
		enabled = true;
		studentTrackerUser = userDTO.buildModel();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public StudentTrackerUser getStudentTrackerUser() {
		return studentTrackerUser;
	}

	@Override
	public String toString() {
		return username + " - " + studentTrackerUser.toString();
	}

}
