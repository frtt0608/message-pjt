package com.heon9u.rcs.study.repository;

import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.send.SendStatus;
import com.heon9u.rcs.study.domain.send.entity.Send;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.heon9u.rcs.study.domain.message.entity.QMessage.message;
import static com.heon9u.rcs.study.domain.rcs.entity.QRcs.rcs;
import static com.heon9u.rcs.study.domain.send.entity.QSend.send;
import static com.heon9u.rcs.study.domain.sendmessage.entity.QSendMessage.sendMessage;

@Repository
public class SendQueryRepository {

    private final JPAQueryFactory query;

    public SendQueryRepository(JPAQueryFactory jpaQueryFactory) {
        this.query = jpaQueryFactory;
    }

    public List<Send> findByAll() {
        return query.select(send)
                .from(send)
                .join(send.rcs, rcs).fetchJoin()
                .join(send, sendMessage.send).fetchJoin()
                .limit(1000)
                .fetch();
    }

    public Send findById(long sendId) {
        return query.select(send)
                .from(send)
                .join(send.rcs, rcs).fetchJoin()
                .join(send, sendMessage.send).fetchJoin()
                .join(sendMessage.message, message).fetchJoin()
                .where(send.id.eq(sendId))
                .fetchOne();
    }

    public List<Send> findByRcsId(Rcs rcs) {
        return query.select(send)
                .from(send)
                .join(send, sendMessage.send).fetchJoin()
                .where(send.rcs.eq(rcs))
                .where(send.status.eq(SendStatus.SEND))
                .fetch();
    }
}