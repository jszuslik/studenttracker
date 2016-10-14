package com.norulesweb.studenttracker.core.services.utilities;

import com.norulesweb.studenttracker.core.model.user.StudentTrackerUser;

public interface UserLookup {
	StudentTrackerUser getCurrentUser();
}
