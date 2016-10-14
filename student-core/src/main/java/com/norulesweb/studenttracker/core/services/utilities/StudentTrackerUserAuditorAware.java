package com.norulesweb.studenttracker.core.services.utilities;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * AuditorAware class to support Spring Data JPA auditing for
 * {@link org.springframework.data.annotation.CreatedBy} and
 * {@link org.springframework.data.annotation.LastModifiedBy} annotations
 * on models.
 */
@Component
public class StudentTrackerUserAuditorAware implements AuditorAware<StudentTrackerUser>
{

	@Autowired
	UserLookup userLookup;

	@Override
	public StudentTrackerUser getCurrentAuditor() {
		return userLookup.getCurrentUser();
	}

}
