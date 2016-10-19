package com.norulesweb.studenttracker.core.model.user;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QStudentTrackerUser is a Querydsl query type for StudentTrackerUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QStudentTrackerUser extends EntityPathBase<StudentTrackerUser> {

    private static final long serialVersionUID = -1088617147L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudentTrackerUser studentTrackerUser = new QStudentTrackerUser("studentTrackerUser");

    public final com.norulesweb.studenttracker.core.model.common.QModelBase _super = new com.norulesweb.studenttracker.core.model.common.QModelBase(this);

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath password = createString("password");

    public final SetPath<StudentTrackerRoles, QStudentTrackerRoles> roles = this.<StudentTrackerRoles, QStudentTrackerRoles>createSet("roles", StudentTrackerRoles.class, QStudentTrackerRoles.class, PathInits.DIRECT2);

    public final QStudentTrackerSystem studentTrackerSystem;

    public final StringPath userId = createString("userId");

    public QStudentTrackerUser(String variable) {
        this(StudentTrackerUser.class, forVariable(variable), INITS);
    }

    public QStudentTrackerUser(Path<? extends StudentTrackerUser> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStudentTrackerUser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStudentTrackerUser(PathMetadata<?> metadata, PathInits inits) {
        this(StudentTrackerUser.class, metadata, inits);
    }

    public QStudentTrackerUser(Class<? extends StudentTrackerUser> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.studentTrackerSystem = inits.isInitialized("studentTrackerSystem") ? new QStudentTrackerSystem(forProperty("studentTrackerSystem")) : null;
    }

}

