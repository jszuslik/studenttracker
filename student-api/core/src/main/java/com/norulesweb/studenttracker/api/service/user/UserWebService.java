package com.norulesweb.studenttracker.api.service.user;

import com.norulesweb.studenttracker.api.utilities.AppConstant;
import com.norulesweb.studenttracker.core.model.user.AppUser;
import com.norulesweb.studenttracker.core.repository.user.AppUserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

import javax.servlet.ServletException;
import java.util.*;

@Service
@Validated
public class UserWebService {

	private static final Logger log = LoggerFactory.getLogger(UserWebService.class);

	@Autowired
	protected AppUserRepository appUserRepository;

	@RequestMapping(path= AppConstant.URL_USER_LOGIN, method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody final UserLogin login)
			throws ServletException {
		AppUser user = appUserRepository.findByUsername(login.username);
		Map<String, List<String>> userDb = null;
		if(user != null){
			userDb = new HashMap<>();
			String[] strRoles = user.getAuthorities().split(",");
			List<String> roles = new ArrayList<>(Arrays.asList(strRoles));
			userDb.put(user.getUsername(), roles);
		}

		if (login.username == null || !userDb.containsKey(login.username)) {
			throw new ServletException("Invalid login");
		}
		LoginResponse loginResponse = new LoginResponse(Jwts.builder().setSubject(login.username)
				                                                .claim("roles", userDb.get(login.username)).setIssuedAt(new Date())
				                                                .signWith(SignatureAlgorithm.HS256, "secretkey").compact());

		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
	}

	@SuppressWarnings("unused")
	private static class UserLogin {
		public String username;
		public String password;
	}

	@SuppressWarnings("unused")
	private static class LoginResponse {
		public String token;

		public LoginResponse(final String token) {
			this.token = token;
		}
	}


}
