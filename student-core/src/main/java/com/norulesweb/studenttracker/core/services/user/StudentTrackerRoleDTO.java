package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerRole;

public class StudentTrackerRoleDTO {

	private Long id;

	private StudentTrackerUserDTO studentTrackerUser;

	private String roleCode;

	private String roleDescription;

	public StudentTrackerRoleDTO() { }

	public StudentTrackerRoleDTO(StudentTrackerRole studentTrackerRole) {
		setId(studentTrackerRole.getId());
		if(studentTrackerRole.getStudentTrackerUser() != null) {
			setStudentTrackerUser(new StudentTrackerUserDTO(studentTrackerRole.getStudentTrackerUser()));
		}
		setRoleCode(studentTrackerRole.getRoleCode());
		setRoleDescription(studentTrackerRole.getRoleDescription());
	}

	public StudentTrackerRole buildModel() {
		StudentTrackerRole role = new StudentTrackerRole();
		role.setId(getId());
		if (getStudentTrackerUser() != null) {
			role.setStudentTrackerUser(getStudentTrackerUser().buildModel());
		}
		role.setRoleCode(getRoleCode());
		role.setRoleDescription(getRoleDescription());
		return role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentTrackerUserDTO getStudentTrackerUser() {
		return studentTrackerUser;
	}

	public void setStudentTrackerUser(StudentTrackerUserDTO studentTrackerUser) {
		this.studentTrackerUser = studentTrackerUser;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
