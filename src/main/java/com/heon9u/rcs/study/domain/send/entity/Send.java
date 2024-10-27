package com.heon9u.rcs.study.domain.send.entity;

import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.send.SendStatus;
import com.heon9u.rcs.study.domain.sendmessage.entity.SendMessage;
import jakarta.persistence.*;
import lombok.Getter;

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

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "SEND_SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rcs_id")
    private Rcs rcs;

    @OneToMany(mappedBy = "send")
    private List<SendMessage> sendMessages = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private SendStatus status;

    private LocalDateTime createTime;
}
