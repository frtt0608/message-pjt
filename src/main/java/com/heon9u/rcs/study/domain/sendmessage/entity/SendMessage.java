package com.heon9u.rcs.study.domain.sendmessage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heon9u.rcs.study.domain.message.entity.Message;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.send.entity.Send;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity(name = "send_messages")
@SequenceGenerator(
        name = "SEND_MESSAGE_SEQ",
        sequenceName = "SEND_MESSAGE_SEQ",
        initialValue = 1,
        allocationSize = 10
)
public class SendMessage {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "SEND_MESSAGE_SEQ")
    @Column(name = "send_message_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "send_id")
    private Send send;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private Message message;

    private Long sendCount;

    private LocalDateTime createTime;

    @Builder
    public SendMessage(Message message, Long sendCount) {
        this.message = message;
        this.sendCount = sendCount;
    }

    public static SendMessage createSendMessage(Message message, Long sendCount) {
        return SendMessage.builder()
                .message(message)
                .sendCount(sendCount)
                .build();
    }

}