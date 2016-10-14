package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;

public class StudentTrackerSystemDTO {

	protected Long id;

	protected String name;

	protected String description;

	public StudentTrackerSystemDTO() { }

	public StudentTrackerSystemDTO(StudentTrackerSystem studentTrackerSystem) {
		setId(studentTrackerSystem.getId());
		setName(studentTrackerSystem.getName());
		setDescription(studentTrackerSystem.getDescription());
	}

	public StudentTrackerSystem buildModel() {
		StudentTrackerSystem studentTrackerSystem = new StudentTrackerSystem();

		studentTrackerSystem.setId(getId());
		studentTrackerSystem.setName(getName());
		studentTrackerSystem.setDescription(getDescription());

		return studentTrackerSystem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
