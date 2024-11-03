package com.heon9u.rcs.study.domain.send.service;

import com.heon9u.rcs.study.domain.message.entity.Message;
import com.heon9u.rcs.study.domain.message.service.MessageService;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.rcs.service.RcsBusinessService;
import com.heon9u.rcs.study.domain.rcs.service.RcsService;
import com.heon9u.rcs.study.domain.send.SendStatus;
import com.heon9u.rcs.study.domain.send.dto.request.SendRequest;
import com.heon9u.rcs.study.domain.send.entity.Send;
import com.heon9u.rcs.study.domain.sendmessage.entity.SendMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Send 도메인의 ComponentService
 * Service 대신 Component(Manager) 역할로 비즈니스 로직 담당
 *
 */

@RequiredArgsConstructor
@Component
public class SendBusinessService {

    private final RcsService rcsService;
    private final RcsBusinessService rcsBusinessService;
    private final MessageService messageService;
    private final SendService sendService;

    // 지금까지 발송한 메시지 갯수와 RCS - maxCount 비교
    @Transactional
    public void send(SendRequest sendRequest) {
        Rcs rcs = rcsService.findById(sendRequest.getRcsId());
        rcsBusinessService.checkRemainCount(rcs, sendRequest.getMessageIds().size());
        List<Message> messageList = messageService.getMessagesById(sendRequest.getMessageIds());

        List<SendMessage> sendMessageList = new ArrayList<>();
        messageList.forEach(message -> {
            sendMessageList.add( SendMessage.createSendMessage(message, 1L) );
        });

        Send send = Send.createSend(rcs, sendMessageList, SendStatus.SEND);
        sendService.save(send);
    }

}
