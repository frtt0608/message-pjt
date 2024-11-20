package com.heon9u.rcs.study.domain.master.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "master")
@SequenceGenerator(
        name = "MASTER_SEQ",
        sequenceName = "MASTER_SEQ",
        initialValue = 1,
        allocationSize = 10
)
public class Master {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "MASTER_SEQ")
    @Column(name = "master_id")
    private Long id;

    @Getter
    @Column(unique = true)
    private String masterName;

    @JsonIgnore
    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL)
    private List<Rcs> rcses = new ArrayList<>();

    private LocalDateTime createTime;

    public Master(String masterName) {
        this.masterName = masterName;
    }

}
