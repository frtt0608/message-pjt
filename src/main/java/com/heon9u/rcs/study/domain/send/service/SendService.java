package com.heon9u.rcs.study.domain.send.service;

import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.send.entity.Send;
import com.heon9u.rcs.study.repository.SendQueryRepository;
import com.heon9u.rcs.study.repository.SendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SendService {

    private final SendRepository sendRepository;
    private final SendQueryRepository sendQueryRepository;

    public List<Send> findByAll() {
        return sendQueryRepository.findByAll();
    }

    public Send findById(Long sendId) {
        return sendQueryRepository.findById(sendId);
    }

    public List<Send> getSendMessageByRcs(Rcs rcs) {
        return sendQueryRepository.findByRcsId(rcs);
    }

    public Send save(Send send) {
        return sendRepository.save(send);
    }
}
