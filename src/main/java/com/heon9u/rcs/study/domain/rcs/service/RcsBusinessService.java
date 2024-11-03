package com.heon9u.rcs.study.domain.rcs.service;

import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.send.entity.Send;
import com.heon9u.rcs.study.domain.send.service.SendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RcsBusinessService {

    private final SendService sendService;

    public void checkRemainCount(Rcs rcs, int messageToSendCount) {
        List<Send> completedSendMessage = sendService.getSendMessageByRcs(rcs);
        rcs.checkRemainCount(completedSendMessage, messageToSendCount);
    }
}
