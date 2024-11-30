package com.heon9u.rcs.study.domain.rcs.dto.request;

import lombok.*;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UpdateRcsRequest {

    private String rcsName;
    private Long maxCount;
}
