package com.norulesweb.studenttracker.model.user;

import com.norulesweb.studenttracker.model.common.ModelBase;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        schema = "studenttracker",
        name = "STUDENT_TRACKER_USER"
)
public class StudentTrackerUser extends ModelBase {

    private String userId;

    private String password;


}
