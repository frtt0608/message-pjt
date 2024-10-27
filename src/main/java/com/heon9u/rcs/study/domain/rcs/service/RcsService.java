package com.heon9u.rcs.study.domain.rcs.service;

import com.heon9u.rcs.study.domain.master.entity.Master;
import com.heon9u.rcs.study.domain.master.service.MasterService;
import com.heon9u.rcs.study.domain.rcs.dto.request.CreateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.dto.request.UpdateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.repository.RcsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RcsService {

    private final RcsRepository rcsRepository;
    private final MasterService masterService;

    public List<Rcs> findByAll() {
        return rcsRepository.findAll();
    }

    public Rcs findById(long rcsId) {
        return rcsRepository.findById(rcsId)
                .orElseThrow(IllegalStateException::new);
    }

    public void create(CreateRcsRequest req) {
        Master master = masterService.findById(req.getMasterId());
        Rcs rcs = Rcs.builder()
                .rcsName(req.getRcsName())
                .maxCount(req.getMaxCount())
                .master(master)
                .build();

        rcsRepository.save(rcs);
    }

    public void update(Long rcsId, UpdateRcsRequest updateRcsRequest) {
        Rcs rcs = findById(rcsId);
        rcs.setRcsName(updateRcsRequest.getRcsName());
        rcs.setMaxCount(updateRcsRequest.getMaxCount());
    }
}
