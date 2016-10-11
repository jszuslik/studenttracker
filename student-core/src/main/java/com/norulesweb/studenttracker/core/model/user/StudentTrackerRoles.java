package com.norulesweb.studenttracker.core.model.user;

import com.norulesweb.studenttracker.core.model.common.ModelBase;
import com.norulesweb.studenttracker.core.model.common.ModelConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        name = "STUDENT_TRACKER_ROLES"
)
public class StudentTrackerRoles extends ModelBase {

    private String role;

    public StudentTrackerRoles() { }

    @Column(name = "ROLE", length = ModelConstants.LEN_NORMAL)
    public String getRole() { return role; }
    public void setRole(String role) {
        this.role = role;
    }

}
