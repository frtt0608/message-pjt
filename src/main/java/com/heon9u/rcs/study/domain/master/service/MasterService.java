package com.heon9u.rcs.study.domain.master.service;

import com.heon9u.rcs.study.domain.master.entity.Master;
import com.heon9u.rcs.study.repository.MasterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MasterService {

    private final MasterRepository masterRepository;

    public List<Master> findByAll() {
        return masterRepository.findAll();
    }

    public Master findById(long masterId) {
        return masterRepository.findById(masterId)
                .orElseThrow(IllegalStateException::new);
    }


    @Transactional
    public void create(Master master) {
        validateDuplicateMasterName(master);
        masterRepository.save(master);
    }

    private void validateDuplicateMasterName(Master master) {
        List<Master> masters = masterRepository.findByMasterName(master.getMasterName());
        if(!masters.isEmpty()) {
            throw new IllegalStateException("중복된 이름입니다.");
        }
    }


}
