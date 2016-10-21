package com.norulesweb.studenttracker.core.model.user;

import com.norulesweb.studenttracker.core.model.common.ModelBase;
import com.norulesweb.studenttracker.core.model.common.ModelConstants;

import javax.persistence.*;

@Entity
@Table(
        name = "STUDENT_TRACKER_ROLES"
)
public class StudentTrackerRole extends ModelBase {

    private StudentTrackerUser studentTrackerUser;

    private String roleCode;

    private String roleDescription;

    public StudentTrackerRole() { }

    public StudentTrackerRole(String roleCode, String roleDescription) {
        this.roleCode = roleCode;
        this.roleDescription = roleDescription;
    }

    @ManyToOne
    @JoinColumn(name = "STUDENT_TRACKER_USER_ID")
    public StudentTrackerUser getStudentTrackerUser() { return studentTrackerUser; }
    public void setStudentTrackerUser(StudentTrackerUser studentTrackerUser) {
        this.studentTrackerUser = studentTrackerUser;
    }

    @Column(name = "ROLE_CODE", length = ModelConstants.LEN_NORMAL)
    public String getRoleCode() { return roleCode; }
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Column(name = "ROLE_DESCRIPTION")
    public String getRoleDescription() { return roleDescription; }
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
