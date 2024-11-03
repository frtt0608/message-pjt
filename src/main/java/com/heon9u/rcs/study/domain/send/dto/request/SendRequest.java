package com.heon9u.rcs.study.domain.send.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class SendRequest {

    private Long rcsId;
    private List<Long> messageIds;
}
