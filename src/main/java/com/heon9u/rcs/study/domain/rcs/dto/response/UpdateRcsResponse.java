package com.heon9u.rcs.study.domain.rcs.dto.response;

import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateRcsResponse {

    private Long rcsId;
    private String rcsName;
    private Long maxCount;

    @Builder
    private UpdateRcsResponse(Long rcsId, String rcsName, Long maxCount) {
        this.rcsId = rcsId;
        this.rcsName = rcsName;
        this.maxCount = maxCount;
    }

    public static UpdateRcsResponse of(Rcs rcs) {
        return UpdateRcsResponse.builder()
                .rcsId(rcs.getId())
                .rcsName(rcs.getRcsName())
                .maxCount(rcs.getMaxCount())
                .build();
    }
}

