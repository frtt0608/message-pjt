package com.heon9u.rcs.study.domain.rcs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class UpdateRcsRequest {

    private String rcsName;
    private Long maxCount;
}
