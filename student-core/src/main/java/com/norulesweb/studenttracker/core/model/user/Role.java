package com.norulesweb.studenttracker.core.model.user;

import com.norulesweb.studenttracker.core.model.common.ModelBase;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
		name = "ROLE"
)
public class Role extends ModelBase {

	private String roleCode;

	private String roleDescription;

	public Role() { }

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
