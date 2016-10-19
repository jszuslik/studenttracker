package com.norulesweb.studenttracker.api.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.security.StudentTrackerUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static final Logger log = LoggerFactory.getLogger(AuthSuccessHandler.class);

	private final ObjectMapper mapper;

	@Autowired
	AuthSuccessHandler(MappingJackson2HttpMessageConverter messageConverter) {
		this.mapper = messageConverter.getObjectMapper();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	                                    Authentication authentication) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);

		StudentTrackerUserDetails userDetails = (StudentTrackerUserDetails) authentication.getPrincipal();
		StudentTrackerUser user = userDetails.getStudentTrackerUser();
		userDetails.setStudentTrackerUser(user);

		log.info(userDetails.getUsername() + " got is connected ");

		PrintWriter writer = response.getWriter();
		mapper.writeValue(writer, user);
		writer.flush();
	}
}
