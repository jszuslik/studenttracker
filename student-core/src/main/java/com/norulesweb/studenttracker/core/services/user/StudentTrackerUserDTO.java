package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerRoles;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;

import java.util.Set;

public class StudentTrackerUserDTO {
	protected Long id;
	
	protected String userName;
	
	protected String password;

	private Set<StudentTrackerRoles> roles;
	
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

	public void setPassword(String password) {
		this.password = password;
	}

	public StudentTrackerSystemDTO getStudentTrackerSystem() {
		return studentTrackerSystem;
	}

	public void setStudentTrackerSystem(StudentTrackerSystemDTO studentTrackerSystem) {
		this.studentTrackerSystem = studentTrackerSystem;
	}
}
