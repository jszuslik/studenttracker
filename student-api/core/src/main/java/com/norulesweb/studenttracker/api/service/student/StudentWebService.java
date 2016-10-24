package com.norulesweb.studenttracker.api.service.student;

import com.norulesweb.studenttracker.api.utilities.AppConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@Validated
public class StudentWebService {

	@RequestMapping(path = AppConstant.URL_USER_REGISTRATION, method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<?> getDaHoney() {
		return ResponseEntity.ok("{\"success\":true}");
	}

}