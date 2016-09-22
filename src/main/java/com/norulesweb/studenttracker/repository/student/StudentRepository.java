package com.norulesweb.studenttracker.repository.student;

import com.norulesweb.studenttracker.model.student.Student;
import com.norulesweb.studenttracker.repository.common.StudentTrackerRepository;

import java.util.List;

public interface StudentRepository extends StudentTrackerRepository<Student, Long> {
    List<Student> findByLastNameAndFirstName(String lastName, String firstName);
    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
}
