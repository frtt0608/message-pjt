package com.heon9u.rcs.study.domain.send.service;

import com.heon9u.rcs.study.common.TestWithDataRollback;
import com.heon9u.rcs.study.domain.message.entity.Message;
import com.heon9u.rcs.study.domain.message.service.MessageService;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.rcs.service.RcsBusinessService;
import com.heon9u.rcs.study.domain.rcs.service.RcsService;
import com.heon9u.rcs.study.domain.send.SendStatus;
import com.heon9u.rcs.study.domain.send.dto.request.SendRequest;
import com.heon9u.rcs.study.domain.send.entity.Send;
import com.heon9u.rcs.study.domain.sendmessage.entity.SendMessage;
import com.heon9u.rcs.study.repository.MessageRepository;
import com.heon9u.rcs.study.repository.RcsRepository;
import com.heon9u.rcs.study.repository.SendQueryRepository;
import com.heon9u.rcs.study.repository.SendRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

/**
 * Send test
 *
 * - rcs 조회 > 남은 카운트 체크
 * - 메시지 조회 > SendMessage 객체 생성
 * - Send 객체 생성 (rcs / SendMessage )
 */


@TestWithDataRollback
class SendBusinessServiceTest {

    @InjectMocks
    SendBusinessService sendBusinessService;

    @Mock
    RcsService rcsService;

    @Mock
    RcsBusinessService rcsBusinessService;

    @Mock
    MessageService messageService;

    @Mock
    SendService sendService;

    @Mock
    RcsRepository rcsRepository;

    @Mock
    SendRepository sendRepository;

    @Mock
    SendQueryRepository sendQueryRepository;

    @Mock
    MessageRepository messageRepository;

    @DisplayName("메시지 발송")
    @Test
    void send() {
        List<Long> messageIds = new ArrayList<>();
        messageIds.add(1L);
        messageIds.add(2L);

        SendRequest sendRequest = SendRequest.builder()
                .rcsId(1L)
                .messageIds(messageIds)
                .build();

        List<Message> messageList = new ArrayList<>();
        Message message1 = Message.builder()
                .id(1L)
                .body("test1")
                .title("t1")
                .build();
        Message message2 = Message.builder()
                .id(2L)
                .body("test2")
                .title("t2")
                .build();

        messageList.add(message1);
        messageList.add(message2);

        Rcs rcs = Rcs.builder()
                .rcsName("test_rcs")
                .maxCount(100L)
                .build();

        List<SendMessage> sendMessageList1 = new ArrayList<>();
        List<SendMessage> sendMessageList2 = new ArrayList<>();
        sendMessageList1.add(SendMessage.builder()
                .message(message1)
                .sendCount(1L)
                .build());
        sendMessageList2.add(SendMessage.builder()
                .message(message2)
                .sendCount(1L)
                .build());

        List<Send> sendList = new ArrayList<>();
        sendList.add(Send.builder()
                .rcs(rcs)
                .sendMessages(sendMessageList1)
                .status(SendStatus.SEND)
                .build());
        sendList.add(Send.builder()
                .rcs(rcs)
                .sendMessages(sendMessageList2)
                .status(SendStatus.SEND)
                .build());

        given(rcsRepository.findById(1L)).willReturn(Optional.of(rcs));
        given(sendQueryRepository.findByRcsId(rcs)).willReturn(sendList);
        given(messageRepository.findAllById(messageIds)).willReturn(messageList);

        sendBusinessService.send(sendRequest);

//        List<SendMessage> sendMessageList = new ArrayList<>();
//        sendMessageList.add(sendMessageList1.getFirst());
//        sendMessageList.add(sendMessageList2.getFirst());
//
//        Send givenSend = Send.builder()
//                .rcs(rcs)
//                .sendMessages(sendMessageList)
//                .status(SendStatus.SEND)
//                .build();
//        givenSend.setId(1L);

//        given(sendRepository.findById(1L)).willReturn(Optional.of(givenSend));
//        assertEquals(sendId, 1L);
    }
}