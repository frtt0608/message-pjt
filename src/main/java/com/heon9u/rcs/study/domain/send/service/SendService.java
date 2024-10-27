package com.heon9u.rcs.study.domain.send.service;

import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.send.dto.request.SendRequest;
import com.heon9u.rcs.study.domain.send.entity.Send;
import com.heon9u.rcs.study.repository.RcsRepository;
import com.heon9u.rcs.study.repository.SendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SendService {

    private final SendRepository sendRepository;
    private final RcsRepository rcsRepository;

    public List<Send> findByAll() {

        return sendRepository.findAll();
    }

    public Send findById(Long sendId) {
        Send send = sendRepository.findById(sendId).orElseThrow();
        Rcs rcs = rcsRepository.findById(send.getId()).orElseThrow();

    }

    public void send(SendRequest sendRequest) {
        Rcs rcs =
    }
}
