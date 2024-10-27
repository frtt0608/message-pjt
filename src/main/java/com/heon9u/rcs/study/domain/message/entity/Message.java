package com.heon9u.rcs.study.domain.message.entity;

import com.heon9u.rcs.study.domain.message.dto.request.CreateMessageRequest;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity(name = "messages")
@SequenceGenerator(
        name = "MESSAGE_SEQ",
        sequenceName = "MESSAGE_SEQ",
        initialValue = 1,
        allocationSize = 10
)
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "MESSAGE_SEQ")
    @Column(name = "message_id")
    private Long id;

    private String title;

    private String body;

    private LocalDateTime createTime;

    @Builder
    private Message(String body, String title) {
        this.body = body;
        this.title = title;
    }

    public static Message of(CreateMessageRequest req) {
        return Message.builder()
                .title(req.getTitle())
                .body(req.getBody())
                .build();
    }

}
