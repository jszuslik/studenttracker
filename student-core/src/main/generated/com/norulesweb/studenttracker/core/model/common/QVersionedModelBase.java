package com.norulesweb.studenttracker.core.model.common;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QVersionedModelBase is a Querydsl query type for VersionedModelBase
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QVersionedModelBase extends EntityPathBase<VersionedModelBase> {

    private static final long serialVersionUID = 2145471136L;

    public static final QVersionedModelBase versionedModelBase = new QVersionedModelBase("versionedModelBase");

    public final QModelBase _super = new QModelBase(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QVersionedModelBase(String variable) {
        super(VersionedModelBase.class, forVariable(variable));
    }

    public QVersionedModelBase(Path<? extends VersionedModelBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVersionedModelBase(PathMetadata<?> metadata) {
        super(VersionedModelBase.class, metadata);
    }

}

