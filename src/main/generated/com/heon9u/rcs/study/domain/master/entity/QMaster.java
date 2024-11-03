package com.heon9u.rcs.study.domain.master.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMaster is a Querydsl query type for Master
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMaster extends EntityPathBase<Master> {

    private static final long serialVersionUID = -1463328783L;

    public static final QMaster master = new QMaster("master");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath masterName = createString("masterName");

    public final ListPath<com.heon9u.rcs.study.domain.rcs.entity.Rcs, com.heon9u.rcs.study.domain.rcs.entity.QRcs> rcses = this.<com.heon9u.rcs.study.domain.rcs.entity.Rcs, com.heon9u.rcs.study.domain.rcs.entity.QRcs>createList("rcses", com.heon9u.rcs.study.domain.rcs.entity.Rcs.class, com.heon9u.rcs.study.domain.rcs.entity.QRcs.class, PathInits.DIRECT2);

    public QMaster(String variable) {
        super(Master.class, forVariable(variable));
    }

    public QMaster(Path<? extends Master> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaster(PathMetadata metadata) {
        super(Master.class, metadata);
    }

}

