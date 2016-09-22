package com.norulesweb.studenttracker.controller;

import com.norulesweb.studenttracker.model.error.ErrorMessage;
import com.norulesweb.studenttracker.model.student.Student;
import com.norulesweb.studenttracker.repository.error.ErrorMessageRepository;
import com.norulesweb.studenttracker.repository.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    protected StudentRepository studentRepository;

    @Autowired
    protected ErrorMessageRepository errorMessageRepository;

    @RequestMapping(value="/createStudent", method={RequestMethod.POST}, produces={"application/json"}, consumes={"application/json"})
    public ResponseEntity<Student> create(@RequestBody Student student) {
        student = studentRepository.save(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(value="/findStudent", method={RequestMethod.POST}, produces={"application/json"}, consumes={"application/json"})
    public Object find(@RequestBody Student student){
        List<Student> students = null;
        if(student.getFirstName() != null && student.getLastName() != null){
            students = studentRepository.findByLastNameAndFirstName(student.getLastName(), student.getFirstName());
        } else if(student.getFirstName() != null){
            students = studentRepository.findByFirstName(student.getFirstName());
        } else if(student.getLastName() != null) {
            students = studentRepository.findByLastName(student.getLastName());
        }

        if(students.size() > 0){
            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        }
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage("No Students Found");
        errorMessage = errorMessageRepository.save(errorMessage);

        return errorMessage;
    }
}
