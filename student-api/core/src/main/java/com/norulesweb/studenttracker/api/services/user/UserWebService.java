package com.norulesweb.studenttracker.api.services.user;

import com.norulesweb.studenttracker.api.utilities.StudentTrackerConstants;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerSystem;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerSystemRepository;
import com.norulesweb.studenttracker.core.repository.user.StudentTrackerUserRepository;
import com.norulesweb.studenttracker.core.services.user.StudentTrackerUserDTO;
import com.norulesweb.studenttracker.core.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@Validated
public class UserWebService {

	private static final Logger log = LoggerFactory.getLogger(UserWebService.class);

	private AuthenticationDetailsSource<HttpServletRequest,?> authenticationDetailsSource = new WebAuthenticationDetailsSource();


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
		return userService.createStudentTrackerUser(user, studentTrackerSystem);
	}

	@RequestMapping(path=StudentTrackerConstants.URL_USER_LOGIN, method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> isCurrentUserLoggedIn(@RequestBody @Valid StudentTrackerUserDTO userDTO, HttpServletRequest request) {
		// Force session creation so it's available to Spring Security post processor filter
		request.getSession(true);

		// Authenticate using AuthenticationManager configured on SecurityContext
		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(userDTO.getUserName(), userDTO.getPassword());
		authReq.setDetails(authenticationDetailsSource.buildDetails(request));
		Authentication authResp = authenticationManager.authenticate(authReq);

		// If successful add the authentication response to context so the post processor filter
		// can save it to session
		SecurityContextHolder.getContext().setAuthentication(authResp);

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@ExceptionHandler(BadCredentialsException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String badCredentialsExceptionHandler(BadCredentialsException e) {
		return "Authentication failed: " + e.getMessage();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String exceptionHandler(Exception e) {
		return "Authentication error: " + e.getMessage();
	}

}
