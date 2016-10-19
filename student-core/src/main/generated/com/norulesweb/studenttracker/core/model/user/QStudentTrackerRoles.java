package com.norulesweb.studenttracker.core.model.user;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QStudentTrackerRoles is a Querydsl query type for StudentTrackerRoles
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QStudentTrackerRoles extends EntityPathBase<StudentTrackerRoles> {

    private static final long serialVersionUID = 609723523L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudentTrackerRoles studentTrackerRoles = new QStudentTrackerRoles("studentTrackerRoles");

    public final com.norulesweb.studenttracker.core.model.common.QModelBase _super = new com.norulesweb.studenttracker.core.model.common.QModelBase(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath roleCode = createString("roleCode");

    public final StringPath roleDescription = createString("roleDescription");

    public final QStudentTrackerUser studentTrackerUser;

    public QStudentTrackerRoles(String variable) {
        this(StudentTrackerRoles.class, forVariable(variable), INITS);
    }

    public QStudentTrackerRoles(Path<? extends StudentTrackerRoles> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStudentTrackerRoles(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStudentTrackerRoles(PathMetadata<?> metadata, PathInits inits) {
        this(StudentTrackerRoles.class, metadata, inits);
    }

    public QStudentTrackerRoles(Class<? extends StudentTrackerRoles> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.studentTrackerUser = inits.isInitialized("studentTrackerUser") ? new QStudentTrackerUser(forProperty("studentTrackerUser"), inits.get("studentTrackerUser")) : null;
    }

}

