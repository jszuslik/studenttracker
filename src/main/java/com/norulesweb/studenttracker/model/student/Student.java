package com.norulesweb.studenttracker.model.student;

import com.norulesweb.studenttracker.model.common.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        schema = "studenttracker",
        name = "STUDENTS"
)
public class Student extends Person {

    private String grade;

    public Student() { }

    @Column(name = "GRADE")
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

}
