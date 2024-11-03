package com.heon9u.rcs.study.domain.message.service;

import com.heon9u.rcs.study.domain.message.dto.request.CreateMessageRequest;
import com.heon9u.rcs.study.domain.message.entity.Message;
import com.heon9u.rcs.study.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public List<Message> findByAll() {
        return messageRepository.findAll();
    }

    public Message findById(Long messageId) {
        return messageRepository.findById(messageId)
                .orElseThrow(IllegalStateException::new);
    }

    public List<Message> getMessagesById(List<Long> messageIds) {
        return messageRepository.findAllById(messageIds);
    }

    public void create(CreateMessageRequest req) {
        Message message = Message.of(req);
        messageRepository.save(message);
    }
}
