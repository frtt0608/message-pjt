package com.heon9u.rcs.study.api;

import com.heon9u.rcs.study.domain.message.dto.request.CreateMessageRequest;
import com.heon9u.rcs.study.domain.message.entity.Message;
import com.heon9u.rcs.study.domain.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/message")
@RestController
public class MessageApiController {

    private final MessageService messageService;

    @GetMapping("")
    public List<Message> list() {
        return messageService.findByAll();
    }

    @GetMapping("/{messageId}")
    public Message findById(@PathVariable Long messageId) {
        return messageService.findById(messageId);
    }

    @PostMapping("/new")
    public void create(@RequestBody CreateMessageRequest req) {
        messageService.create(req);
    }


}
