package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;

import java.util.HashSet;
import java.util.Set;

public class StudentTrackerUserDTO {
	protected Long id;
	
	protected String userName;
	
	protected String password;

	protected String userEmail;

	private Set<StudentTrackerRoleDTO> roles;
	
	protected StudentTrackerSystemDTO studentTrackerSystem;

	public StudentTrackerUserDTO() { }

	public StudentTrackerUserDTO(StudentTrackerUser studentTrackerUser) {
		setId(studentTrackerUser.getId());
		setUserName(studentTrackerUser.getUserName());
		setPassword(studentTrackerUser.getPassword());
		if (studentTrackerUser.getStudentTrackerSystem() != null)
			setStudentTrackerSystem(new StudentTrackerSystemDTO(studentTrackerUser.getStudentTrackerSystem()));
	}

	public StudentTrackerUser buildModel() {
		StudentTrackerUser user = new StudentTrackerUser();
		user.setId(getId());
		user.setUserName(getUserName());
		// Don't even expose the password here...

		if (getStudentTrackerSystem() != null)
			user.setStudentTrackerSystem(getStudentTrackerSystem().buildModel());
		return user;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<StudentTrackerRoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<StudentTrackerRoleDTO> roles) {
		this.roles = roles;
	}

	public void addRole(StudentTrackerRoleDTO role){
		if(this.roles == null){
			this.roles = new HashSet<>();
		}
		this.roles.add(role);
	}

	public StudentTrackerSystemDTO getStudentTrackerSystem() {
		return studentTrackerSystem;
	}

	public void setStudentTrackerSystem(StudentTrackerSystemDTO studentTrackerSystem) {
		this.studentTrackerSystem = studentTrackerSystem;
	}
}
