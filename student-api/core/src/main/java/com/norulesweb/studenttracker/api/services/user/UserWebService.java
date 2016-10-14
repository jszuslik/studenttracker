package com.norulesweb.studenttracker.api.services.user;

import com.norulesweb.studenttracker.core.services.user.StudentTrackerUserDTO;
import com.norulesweb.studenttracker.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Validated
public class UserWebService {

	public static final String URL_USER_BASE = "/user";

	public static final String URL_USER_REGISTRATION = URL_USER_BASE + "/registration";

	@Autowired
	protected UserService userService;

	@RequestMapping(path=URL_USER_REGISTRATION)
	public @ResponseBody
	StudentTrackerUserDTO registerNewUser(@RequestBody StudentTrackerUserDTO user ) {
		return userService.createStudentTrackerUser(user.getUserId(), user.getPassword(), new Long(1));
	}

}
