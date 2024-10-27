package com.heon9u.rcs.study.domain.rcs.dto.request;

import lombok.Getter;

@Getter
public class CreateRcsRequest {

    private String rcsName;
    private Long maxCount;
    private Long masterId;
}
