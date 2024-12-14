package com.heon9u.rcs.study.domain.send.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.send.SendStatus;
import com.heon9u.rcs.study.domain.sendmessage.entity.SendMessage;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sends")
@SequenceGenerator(
        name = "SEND_SEQ",
        sequenceName = "SEND_SEQ",
        initialValue = 1,
        allocationSize = 10
)
@Getter
public class Send {

    @Setter
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "SEND_SEQ")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcs_id")
    private Rcs rcs;

    @OneToMany(mappedBy = "send", cascade = CascadeType.ALL)
    private List<SendMessage> sendMessages = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private SendStatus status;

    private LocalDateTime createTime;

    @Builder
    public Send(Rcs rcs, List<SendMessage> sendMessages, SendStatus status) {
        this.rcs = rcs;
        this.sendMessages = sendMessages;
        this.status = status;
    }

    public static Send createSend(Rcs rcs, List<SendMessage> sendMessages, SendStatus status) {
        return Send.builder()
                .rcs(rcs)
                .sendMessages(sendMessages)
                .status(status)
                .build();
    }
}
