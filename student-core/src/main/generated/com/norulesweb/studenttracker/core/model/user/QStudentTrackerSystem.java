package com.norulesweb.studenttracker.core.model.user;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QStudentTrackerSystem is a Querydsl query type for StudentTrackerSystem
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QStudentTrackerSystem extends EntityPathBase<StudentTrackerSystem> {

    private static final long serialVersionUID = 1759647017L;

    public static final QStudentTrackerSystem studentTrackerSystem = new QStudentTrackerSystem("studentTrackerSystem");

    public final com.norulesweb.studenttracker.core.model.common.QModelBase _super = new com.norulesweb.studenttracker.core.model.common.QModelBase(this);

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final BooleanPath isInternal = createBoolean("isInternal");

    public final StringPath name = createString("name");

    public QStudentTrackerSystem(String variable) {
        super(StudentTrackerSystem.class, forVariable(variable));
    }

    public QStudentTrackerSystem(Path<? extends StudentTrackerSystem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentTrackerSystem(PathMetadata<?> metadata) {
        super(StudentTrackerSystem.class, metadata);
    }

}

