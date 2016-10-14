package com.norulesweb.studenttracker.api.common;

import org.springframework.validation.FieldError;

import javax.validation.ValidationException;
import java.util.List;

public class StudentTrackerDataValidationException extends ValidationException {

	private static final long serialVersionUID = 9111014661644720446L;

	public StudentTrackerDataValidationException() {
		super();
	}

	public StudentTrackerDataValidationException(String message) {
		super(message);
	}

	private List<FieldError> fieldErrors;

}
