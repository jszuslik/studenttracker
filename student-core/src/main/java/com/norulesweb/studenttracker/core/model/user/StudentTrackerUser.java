package com.norulesweb.studenttracker.core.model.user;

import com.norulesweb.studenttracker.core.model.common.ModelBase;
import com.norulesweb.studenttracker.core.model.common.ModelConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * A StudentTracker user.  This could be an internal user (StudentTracker workers) or an
 * external user (outside platform/manufacturer/supplier).  Internal users may have
 * access to APIs that are not exposed to external users.  External users will typically
 * have additional details (a unique ID from their own external platform, maybe name, etc.)
 */
@Entity
@Table(
        name="STUDENT_TRACKER_USER",
        indexes = {
                @Index(columnList = "USER_ID")
        }
)
public class StudentTrackerUser extends ModelBase {

    private String userId;

    private String password;

    private String email;

    private StudentTrackerRoles role;

    private StudentTrackerSystem studentTrackerSystem;

    public StudentTrackerUser() { }

    @Column(name = "USER_ID", length = ModelConstants.LEN_MEDIUM)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "PASSWORD", length = ModelConstants.LEN_NORMAL)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "EMAIL", length = ModelConstants.LEN_NORMAL)
    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @JoinColumn(name = "ROLE")
    public StudentTrackerRoles getRole() { return role; }
    public void setRole(StudentTrackerRoles role) {
        this.role = role;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "STUDENT_TRACKER_SYSTEM_ID")
    public StudentTrackerSystem getStudentTrackerSystem() {
        return studentTrackerSystem;
    }

    public void setStudentTrackerSystem(StudentTrackerSystem studentTrackerSystem) {
        this.studentTrackerSystem = studentTrackerSystem;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userId", userId)
                .toString();
    }
}
