package com.norulesweb.studenttracker.api.services.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@Validated
public class UserWebService {

	private static final Logger log = LoggerFactory.getLogger(UserWebService.class);

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse response) {
		return "GET Received";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(HttpServletRequest request, HttpServletResponse response) {
		return "POST Received";
	}

}
