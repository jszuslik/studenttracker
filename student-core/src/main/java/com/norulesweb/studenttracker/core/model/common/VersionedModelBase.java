package com.norulesweb.studenttracker.core.model.common;

import javax.persistence.*;

/**
 * ModelBase extended to implement JPA @Version optimistic locking strategy.
 */
@MappedSuperclass
public abstract class VersionedModelBase extends ModelBase {

    protected Long version = new Long(0);

    public VersionedModelBase() { }

    public VersionedModelBase(VersionedModelBase versionedModelBase) {
        super(versionedModelBase);
        setVersion(versionedModelBase.getVersion());
    }

    @Version
    @Column(name="VERSION", nullable=false)
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}

