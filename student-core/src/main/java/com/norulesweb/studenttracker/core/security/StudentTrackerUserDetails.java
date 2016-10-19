package com.norulesweb.studenttracker.core.security;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Basic Spring Security implementation of {@link org.springframework.security.core.userdetails.UserDetails}
 */
public class StudentTrackerUserDetails implements UserDetails {

	private List<GrantedAuthority> authorities;
	
	private StudentTrackerUser studentTrackerUser;

	public StudentTrackerUserDetails() { }

	public StudentTrackerUserDetails(StudentTrackerUserDTO studentTrackerUserDTO ) {
		this.studentTrackerUser.setUserId(studentTrackerUserDTO.getUserId());
	}
	
	public StudentTrackerUserDetails(StudentTrackerUser studentTrackerUser, List<GrantedAuthority> authorities) {
		this.studentTrackerUser = studentTrackerUser;
		this.authorities = authorities;
	}

	public StudentTrackerUser getStudentTrackerUser() {
		return studentTrackerUser;
	}

	public void setStudentTrackerUser(StudentTrackerUser studentTrackerUser) {
		this.studentTrackerUser = studentTrackerUser;
	}

	@Override
	public String getPassword() {
		return studentTrackerUser.getPassword();
	}

	@Override
	public String getUsername() {
		return studentTrackerUser.getUserId();
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
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

}
