package com.heon9u.rcs.study.domain.rcs.dto.request;

import lombok.Getter;

@Getter
public class UpdateRcsRequest {

    private String rcsName;
    private Long maxCount;
}
