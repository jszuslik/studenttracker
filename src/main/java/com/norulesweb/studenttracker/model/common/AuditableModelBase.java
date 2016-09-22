package com.norulesweb.studenttracker.model.common;

import com.norulesweb.studenttracker.model.user.StudentTrackerUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableModelBase extends VersionedModelBase {
    protected Instant createdOn;

    protected Instant updatedOn;

    protected StudentTrackerUser createdBy;

    protected StudentTrackerUser updatedBy;

    public AuditableModelBase() { }

    public AuditableModelBase(AuditableModelBase auditableModelBase) {
        super(auditableModelBase);
        setCreatedOn(auditableModelBase.getCreatedOn());
        setUpdatedOn(auditableModelBase.getUpdatedOn());
        setCreatedBy(auditableModelBase.getCreatedBy());
        setUpdatedBy(auditableModelBase.getUpdatedBy());
    }

    /**
     * Date created
     */
    @CreatedDate
    @Column(name="CREATED_ON_UTC", nullable=false)
    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * Date last modified
     */
    @LastModifiedDate
    @Column(name="UPDATED_ON_UTC")
    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * Created by user
     */
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="CREATED_BY_STUDENT_TRACKER_USER_ID")
    public StudentTrackerUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(StudentTrackerUser createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Last modified by user
     */
    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="UPDATED_BY_STUDENT_TRACKER_USER_ID")
    public StudentTrackerUser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(StudentTrackerUser updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("createdOn", createdOn)
                //.append("createdBy", createdBy)
                .append("updatedOn", updatedOn)
                //.append("updatedBy", updatedBy)
                .toString();
    }

}
