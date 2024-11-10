package com.heon9u.rcs.study.domain.master.service;

import com.heon9u.rcs.study.domain.master.dto.request.CreateMasterRequest;
import com.heon9u.rcs.study.domain.master.entity.Master;
import com.heon9u.rcs.study.global.exception.BusinessException;
import com.heon9u.rcs.study.repository.MasterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MasterService {

    private final MasterRepository masterRepository;

    public List<Master> getMasterList() {
        return masterRepository.findAll();
    }

    public Master getMaster(long masterId) {
        return masterRepository.findById(masterId)
                .orElseThrow(() -> new BusinessException("master non exist."));
    }

    @Transactional
    public void create(CreateMasterRequest req) {
        Master master = new Master(req.getMasterName());
        validateDuplicatedMasterName(master);
        masterRepository.save(master);
    }

    private void validateDuplicatedMasterName(Master master) {
        Master masters = masterRepository.findByMasterName(master.getMasterName());
        if(!ObjectUtils.isEmpty(masters)) {
            throw new IllegalStateException("duplicated master name.");
        }
    }


}
