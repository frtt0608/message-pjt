package com.heon9u.rcs.study.domain.send.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class SendRequest {

    private Long rcsId;
    private List<Long> messageIds;
}
