package com.heon9u.rcs.study.domain.rcs.service;

import com.heon9u.rcs.study.common.TestWithDataRollback;
import com.heon9u.rcs.study.domain.master.service.MasterService;
import com.heon9u.rcs.study.domain.rcs.dto.request.CreateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.dto.request.UpdateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.repository.RcsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@TestWithDataRollback
class RcsServiceTest {

    @InjectMocks
    RcsService rcsService;

    @Mock
    MasterService masterService;

    @Mock
    RcsRepository rcsRepository;

    @Test
    void findByAll() {
        List<Rcs> rcsList = new ArrayList<>();
        rcsList.add(Rcs.builder()
                        .rcsName("rcsTest")
                        .maxCount(100L)
                        .build());

        given(rcsRepository.findAll()).willReturn(rcsList);

        List<Rcs> result = rcsService.findByAll();

        assertEquals(rcsList.size(), result.size());
    }

    @Test
    void findById() {
        Long id = 1L;
        Rcs rcs = Rcs.builder()
                .rcsName("testRcs")
                .maxCount(100L)
                .build();
        rcs.setId(id);

        given(rcsRepository.findById(id)).willReturn(Optional.of(rcs));

        Rcs findRcs = rcsService.findById(id);

        assertEquals(rcs.getRcsName(), findRcs.getRcsName());
    }

    @Test
    void create() {
        Rcs rcs = Rcs.builder()
                .rcsName("testRcs")
                .maxCount(100L)
                .build();
        rcs.setId(1L);

        CreateRcsRequest crr = CreateRcsRequest.builder()
                .rcsName("testRcs")
                .maxCount(100L)
                .masterId(1L)
                .build();

        given(rcsRepository.save(any(Rcs.class))).willReturn(rcs);

        Long id = rcsService.create(crr);
        assertEquals(1L, id);
        verify(rcsRepository, times(1)).save(any(Rcs.class));
    }

    @Test
    void update() {
        UpdateRcsRequest urr = UpdateRcsRequest.builder()
                .rcsName("testRcs2")
                .maxCount(200L)
                .build();

        Rcs rcs = Rcs.builder()
                .rcsName("testRcs1")
                .maxCount(100L)
                .build();
        Long id = 1L;
        rcs.setId(id);

        given(rcsRepository.findById(id)).willReturn(Optional.of(rcs));

        rcsService.update(id, urr);

        assertEquals("testRcs2", urr.getRcsName());
        assertEquals(200L, urr.getMaxCount());
    }
}