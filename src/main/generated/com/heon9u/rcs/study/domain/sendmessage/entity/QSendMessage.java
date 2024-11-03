package com.heon9u.rcs.study.domain.sendmessage.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSendMessage is a Querydsl query type for SendMessage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSendMessage extends EntityPathBase<SendMessage> {

    private static final long serialVersionUID = 583729171L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSendMessage sendMessage = new QSendMessage("sendMessage");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.heon9u.rcs.study.domain.message.entity.QMessage message;

    public final com.heon9u.rcs.study.domain.send.entity.QSend send;

    public final NumberPath<Long> sendCount = createNumber("sendCount", Long.class);

    public QSendMessage(String variable) {
        this(SendMessage.class, forVariable(variable), INITS);
    }

    public QSendMessage(Path<? extends SendMessage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSendMessage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSendMessage(PathMetadata metadata, PathInits inits) {
        this(SendMessage.class, metadata, inits);
    }

    public QSendMessage(Class<? extends SendMessage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.message = inits.isInitialized("message") ? new com.heon9u.rcs.study.domain.message.entity.QMessage(forProperty("message")) : null;
        this.send = inits.isInitialized("send") ? new com.heon9u.rcs.study.domain.send.entity.QSend(forProperty("send"), inits.get("send")) : null;
    }

}

