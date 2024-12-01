package com.heon9u.rcs.study.domain.rcs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heon9u.rcs.study.domain.master.entity.Master;
import com.heon9u.rcs.study.domain.send.entity.Send;
import com.heon9u.rcs.study.global.exception.BusinessException;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "rcs")
@SequenceGenerator(
        name = "RCS_SEQ",
        sequenceName = "RCS_SEQ",
        initialValue = 1,
        allocationSize = 10
)
@Getter
public class Rcs {

    @Setter
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "RCS_SEQ")
    @Column(name = "rcs_id")
    private Long id;

    @Setter
    @Column(unique = true)
    private String rcsName;

    @Setter
    private Long maxCount;

    private LocalDateTime createTime;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    private Master master;

    @OneToMany(mappedBy = "rcs", cascade = CascadeType.ALL)
    private List<Send> sends = new ArrayList<>();

    @Builder
    public Rcs(String rcsName, Long maxCount, Master master) {
        this.rcsName = rcsName;
        this.maxCount = maxCount;
        this.master = master;
    }

    public void checkRemainCount(List<Send> completedSendMessage, int messageToSendCount) {
        int completedCount = messageToSendCount;
        for(Send send: completedSendMessage) {
            completedCount += send.getSendMessages().size();

            if(maxCount <= completedCount) break;
        }

        if(maxCount <= completedCount) {
            throw new BusinessException("over max Count!! " + "maxCount: " + maxCount + ", completedCount: " + completedCount);
        }
    }
}
