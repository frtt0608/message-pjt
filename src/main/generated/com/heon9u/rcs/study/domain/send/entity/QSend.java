package com.heon9u.rcs.study.domain.send.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSend is a Querydsl query type for Send
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSend extends EntityPathBase<Send> {

    private static final long serialVersionUID = 1778441469L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSend send = new QSend("send");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.heon9u.rcs.study.domain.rcs.entity.QRcs rcs;

    public final ListPath<com.heon9u.rcs.study.domain.sendmessage.entity.SendMessage, com.heon9u.rcs.study.domain.sendmessage.entity.QSendMessage> sendMessages = this.<com.heon9u.rcs.study.domain.sendmessage.entity.SendMessage, com.heon9u.rcs.study.domain.sendmessage.entity.QSendMessage>createList("sendMessages", com.heon9u.rcs.study.domain.sendmessage.entity.SendMessage.class, com.heon9u.rcs.study.domain.sendmessage.entity.QSendMessage.class, PathInits.DIRECT2);

    public final EnumPath<com.heon9u.rcs.study.domain.send.SendStatus> status = createEnum("status", com.heon9u.rcs.study.domain.send.SendStatus.class);

    public QSend(String variable) {
        this(Send.class, forVariable(variable), INITS);
    }

    public QSend(Path<? extends Send> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSend(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSend(PathMetadata metadata, PathInits inits) {
        this(Send.class, metadata, inits);
    }

    public QSend(Class<? extends Send> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.rcs = inits.isInitialized("rcs") ? new com.heon9u.rcs.study.domain.rcs.entity.QRcs(forProperty("rcs"), inits.get("rcs")) : null;
    }

}

