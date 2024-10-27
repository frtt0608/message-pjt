package com.heon9u.rcs.study.domain.sendmessage.entity;

import com.heon9u.rcs.study.domain.message.entity.Message;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.send.entity.Send;
import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "send_id")
    private Send send;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;

    private Long sendCount;

    private LocalDateTime createTime;

}