package com.norulesweb.studenttracker.model.teacher;

import com.norulesweb.studenttracker.model.common.VersionedModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        schema = "studenttracker",
        name = "TEACHER"
)
public class Teacher extends VersionedModelBase {

    private String role;

    private String gradeTaught;

    public Teacher() { }

    @Column(name = "ROLE")
    public String getRole() { return role; }
    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "GRADE_TAUGHT")
    public String getGradeTaught() { return gradeTaught; }
    public void setGradeTaught(String gradeTaught) {
        this.gradeTaught = gradeTaught;
    }
}
