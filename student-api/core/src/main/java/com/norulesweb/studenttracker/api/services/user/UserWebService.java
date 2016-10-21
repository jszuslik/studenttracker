package com.norulesweb.studenttracker.api.services.user;

import com.norulesweb.studenttracker.api.utilities.StudentTrackerConstants;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerSystemRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerUserRepository;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@Validated
public class UserWebService {

	private static final Logger log = LoggerFactory.getLogger(UserWebService.class);

	@Autowired
	protected StudentTrackerSystemRepository studentTrackerSystemRepository;

	@Autowired
	protected StudentTrackerUserRepository studentTrackerUserRepository;

	@RequestMapping(path=StudentTrackerConstants.URL_USER_REGISTRATION, method = RequestMethod.POST)
	public @ResponseBody
	ResponseEntity<String> registerNewUser(@RequestBody @Valid StudentTrackerUserDTO user ) {
		StudentTrackerSystem studentTrackerSystem = studentTrackerSystemRepository.findByName(user.getStudentTrackerSystem().getName());
		return new ResponseEntity<>(studentTrackerSystem.getDescription(), HttpStatus.OK);
	}

	@RequestMapping(path=StudentTrackerConstants.URL_USER_LOGIN, method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> isCurrentUserLoggedIn(@RequestBody @Valid StudentTrackerUserDTO userDTO) {
		List<StudentTrackerUser> users = studentTrackerUserRepository.findByUserName(userDTO.getUserName());
		String user = users.get(0).getUserName();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}


}
