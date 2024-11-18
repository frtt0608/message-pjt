package com.heon9u.rcs.study.domain.rcs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class CreateRcsRequest {

    private String rcsName;
    private Long maxCount;
    private Long masterId;
}
