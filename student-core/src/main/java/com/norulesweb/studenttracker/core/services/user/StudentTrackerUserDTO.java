package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;

public class StudentTrackerUserDTO {
	protected Long id;
	
	protected String userId;
	
	protected String password;
	
	protected StudentTrackerSystemDTO studentTrackerSystem;

	public StudentTrackerUserDTO() { }

	public StudentTrackerUserDTO(StudentTrackerUser studentTrackerUser) {
		setId(studentTrackerUser.getId());
		setUserId(studentTrackerUser.getUserId());
		setPassword(studentTrackerUser.getPassword());
		if (studentTrackerUser.getStudentTrackerSystem() != null)
			setStudentTrackerSystem(new StudentTrackerSystemDTO(studentTrackerUser.getStudentTrackerSystem()));
	}

	public StudentTrackerUser buildModel() {
		StudentTrackerUser user = new StudentTrackerUser();
		user.setId(getId());
		user.setUserId(getUserId());
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
