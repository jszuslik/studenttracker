package com.norulesweb.studenttracker.api.services.user;

import com.norulesweb.studenttracker.api.utilities.StudentTrackerConstants;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerSystemRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerUserRepository;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerUserDTO;
import com.norulesweb.studenttracker.core.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@Validated
public class UserWebService {

	private static final Logger log = LoggerFactory.getLogger(UserWebService.class);

	@Autowired
	protected AuthenticationManager authenticationManager;

	@Autowired
	protected UserService userService;

	@Autowired
	protected StudentTrackerSystemRepository studentTrackerSystemRepository;

	@Autowired
	protected StudentTrackerUserRepository studentTrackerUserRepository;

	@RequestMapping(path=StudentTrackerConstants.URL_USER_REGISTRATION, method = RequestMethod.POST)
	public @ResponseBody
	StudentTrackerUserDTO registerNewUser(@RequestBody @Valid StudentTrackerUserDTO user ) {
		StudentTrackerSystem studentTrackerSystem = studentTrackerSystemRepository.findByName(user.getStudentTrackerSystem().getName());
		return userService.createStudentTrackerUser(user.getUserId(), user.getPassword(), studentTrackerSystem);
	}

	@RequestMapping(path=StudentTrackerConstants.URL_USER_LOGIN, method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> isCurrentUserLoggedIn(@RequestBody @Valid StudentTrackerUserDTO userDTO, HttpServletRequest request) {
		List<StudentTrackerUser> users = studentTrackerUserRepository.findByUserId(userDTO.getUserId());

		log.info("HTTP Request - {}", request);

		authenticateUserAndSetSession(users.get(0), request);

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	private void authenticateUserAndSetSession(StudentTrackerUser user, HttpServletRequest request) {
		String username = user.getUserId();
		String password = user.getPassword();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password);

		// generate session if one doesn't exist
		request.getSession();

		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

	}

}
