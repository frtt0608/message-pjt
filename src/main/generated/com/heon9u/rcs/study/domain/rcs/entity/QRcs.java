package com.heon9u.rcs.study.domain.rcs.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRcs is a Querydsl query type for Rcs
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRcs extends EntityPathBase<Rcs> {

    private static final long serialVersionUID = -629370797L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRcs rcs = new QRcs("rcs");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.heon9u.rcs.study.domain.master.entity.QMaster master;

    public final NumberPath<Long> maxCount = createNumber("maxCount", Long.class);

    public final StringPath rcsName = createString("rcsName");

    public final ListPath<com.heon9u.rcs.study.domain.send.entity.Send, com.heon9u.rcs.study.domain.send.entity.QSend> sends = this.<com.heon9u.rcs.study.domain.send.entity.Send, com.heon9u.rcs.study.domain.send.entity.QSend>createList("sends", com.heon9u.rcs.study.domain.send.entity.Send.class, com.heon9u.rcs.study.domain.send.entity.QSend.class, PathInits.DIRECT2);

    public QRcs(String variable) {
        this(Rcs.class, forVariable(variable), INITS);
    }

    public QRcs(Path<? extends Rcs> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRcs(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRcs(PathMetadata metadata, PathInits inits) {
        this(Rcs.class, metadata, inits);
    }

    public QRcs(Class<? extends Rcs> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.master = inits.isInitialized("master") ? new com.heon9u.rcs.study.domain.master.entity.QMaster(forProperty("master")) : null;
    }

}

