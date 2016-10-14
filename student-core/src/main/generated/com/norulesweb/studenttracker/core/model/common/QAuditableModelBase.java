package com.norulesweb.studenttracker.core.model.common;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAuditableModelBase is a Querydsl query type for AuditableModelBase
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QAuditableModelBase extends EntityPathBase<AuditableModelBase> {

    private static final long serialVersionUID = -443598814L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuditableModelBase auditableModelBase = new QAuditableModelBase("auditableModelBase");

    public final QVersionedModelBase _super = new QVersionedModelBase(this);

    public final com.norulesweb.studenttracker.core.model.user.QStudentTrackerUser createdBy;

    public final DateTimePath<java.time.Instant> createdOn = createDateTime("createdOn", java.time.Instant.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final com.norulesweb.studenttracker.core.model.user.QStudentTrackerUser updatedBy;

    public final DateTimePath<java.time.Instant> updatedOn = createDateTime("updatedOn", java.time.Instant.class);

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QAuditableModelBase(String variable) {
        this(AuditableModelBase.class, forVariable(variable), INITS);
    }

    public QAuditableModelBase(Path<? extends AuditableModelBase> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAuditableModelBase(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAuditableModelBase(PathMetadata<?> metadata, PathInits inits) {
        this(AuditableModelBase.class, metadata, inits);
    }

    public QAuditableModelBase(Class<? extends AuditableModelBase> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.norulesweb.studenttracker.core.model.user.QStudentTrackerUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.updatedBy = inits.isInitialized("updatedBy") ? new com.norulesweb.studenttracker.core.model.user.QStudentTrackerUser(forProperty("updatedBy"), inits.get("updatedBy")) : null;
    }

}

