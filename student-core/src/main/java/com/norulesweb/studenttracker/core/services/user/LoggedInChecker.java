package com.norulesweb.studenttracker.core.services.user;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.security.StudentTrackerUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoggedInChecker {
	public StudentTrackerUser getLoggedInUser() {
		StudentTrackerUser user = null;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();

			// principal can be "anonymousUser" (String)
			if (principal instanceof StudentTrackerUserDetails) {
				StudentTrackerUserDetails userDetails = (StudentTrackerUserDetails) principal;
				user = userDetails.getStudentTrackerUser();
			}
		}

		return user;
	}
}

