package com.heon9u.rcs.study.domain.rcs.service;

import com.heon9u.rcs.study.domain.master.entity.Master;
import com.heon9u.rcs.study.domain.master.service.MasterService;
import com.heon9u.rcs.study.domain.rcs.dto.request.CreateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.dto.request.UpdateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.global.exception.BusinessException;
import com.heon9u.rcs.study.repository.RcsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
                .orElseThrow(() -> new BusinessException("rcs non exist."));
    }

    @Transactional
    public Long create(CreateRcsRequest req) {
        validateDuplicatedRcsName(req.getRcsName());
        Master master = masterService.getMaster(req.getMasterId());
        Rcs rcs = Rcs.builder()
                .rcsName(req.getRcsName())
                .maxCount(req.getMaxCount())
                .master(master)
                .build();

        rcs = rcsRepository.save(rcs);
        return rcs.getId();
    }

    public void validateDuplicatedRcsName(String rcsName) {
        Rcs rcs = rcsRepository.findByRcsName(rcsName);
        if(!ObjectUtils.isEmpty(rcs)) {
            throw new BusinessException("duplicated rcs name.");
        }
    }

    @Transactional
    public void update(Long rcsId, UpdateRcsRequest updateRcsRequest) {
        Rcs rcs = findById(rcsId);
        rcs.setRcsName(updateRcsRequest.getRcsName());
        rcs.setMaxCount(updateRcsRequest.getMaxCount());
        rcsRepository.save(rcs);
    }
}
