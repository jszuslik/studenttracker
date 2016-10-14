package com.norulesweb.studenttracker.core.model.user;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QStudentTrackerRoles is a Querydsl query type for StudentTrackerRoles
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QStudentTrackerRoles extends EntityPathBase<StudentTrackerRoles> {

    private static final long serialVersionUID = 609723523L;

    public static final QStudentTrackerRoles studentTrackerRoles = new QStudentTrackerRoles("studentTrackerRoles");

    public final com.norulesweb.studenttracker.core.model.common.QModelBase _super = new com.norulesweb.studenttracker.core.model.common.QModelBase(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath role = createString("role");

    public QStudentTrackerRoles(String variable) {
        super(StudentTrackerRoles.class, forVariable(variable));
    }

    public QStudentTrackerRoles(Path<? extends StudentTrackerRoles> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentTrackerRoles(PathMetadata<?> metadata) {
        super(StudentTrackerRoles.class, metadata);
    }

}

