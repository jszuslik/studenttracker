package com.norulesweb.studenttracker.core.services.utilities;


import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import com.norulesweb.studenttracker.core.security.StudentTrackerUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserLookupImpl implements UserLookup {

	@Override
	public StudentTrackerUser getCurrentUser() {
		StudentTrackerUser returnUser = null;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			StudentTrackerUserDetails userDetails = (StudentTrackerUserDetails) auth.getPrincipal();
			if (userDetails != null)
				returnUser = userDetails.getStudentTrackerUser();
		}

		return returnUser;
	}

}
