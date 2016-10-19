package com.norulesweb.studenttracker.core.model.user;

import com.norulesweb.studenttracker.core.model.common.ModelBase;
import com.norulesweb.studenttracker.core.model.common.ModelConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * A StudentTracker system.  This could be a partner (school, district)
 * or platform, or the internal StudentTracker system itself.
 */
@Entity
@Table(
        name="STUDENT_TRACKER_SYSTEM",
        indexes = {
                @Index(columnList = "NAME")
        }
)
public class StudentTrackerSystem extends ModelBase {

    private String name;

    private String description;

    public StudentTrackerSystem() { }

    public StudentTrackerSystem(Long id) {
        super(id);
    }

    /**
     * Name of the system
     */
    @Column(name = "NAME", length = ModelConstants.LEN_NORMAL)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Description of the system
     */
    @Column(name = "DESCRIPTION", length = ModelConstants.LEN_NORMAL)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

