package com.norulesweb.studenttracker.model.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class VersionedModelBase extends ModelBase {
    protected Long version = new Long(1);

    public VersionedModelBase() { }

    public VersionedModelBase(VersionedModelBase versionedModelBase) {
        super(versionedModelBase);
        setVersion(versionedModelBase.getVersion());
    }

    @Version
    @Column(name="VERSION", nullable=false)
    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }

}
