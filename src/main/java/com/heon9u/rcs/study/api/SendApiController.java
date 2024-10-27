package com.heon9u.rcs.study.api;

import com.heon9u.rcs.study.domain.send.dto.request.SendRequest;
import com.heon9u.rcs.study.domain.send.entity.Send;
import com.heon9u.rcs.study.domain.send.service.SendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/send")
@RestController
public class SendApiController {

    private final SendService sendService;

    @GetMapping()
    public List<Send> list() {
        return sendService.findByAll();
    }

    @GetMapping("/{sendId}")
    public Send findById(@PathVariable Long sendId) {
        return sendService.findById(sendId);
    }

    @PostMapping("/send-message")
    public void send(@RequestBody SendRequest sendRequest) {
        sendService.send(sendRequest);
    }

}
