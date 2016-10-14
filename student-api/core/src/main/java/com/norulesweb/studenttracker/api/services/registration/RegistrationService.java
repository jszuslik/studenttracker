package com.norulesweb.studenttracker.api.services.registration;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Validated
public class RegistrationService {

	public static final String URL_REGISTRATION_BASE = "/registration";

	@RequestMapping(value = URL_REGISTRATION_BASE, method= RequestMethod.POST)
	public @ResponseBody
	RegistrationServiceResponse registerNewUser(){

	}


}
