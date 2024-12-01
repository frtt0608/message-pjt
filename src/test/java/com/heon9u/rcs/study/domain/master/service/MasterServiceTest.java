package com.heon9u.rcs.study.domain.master.service;

import com.heon9u.rcs.study.common.TestWithDataRollback;
import com.heon9u.rcs.study.domain.master.dto.request.CreateMasterRequest;
import com.heon9u.rcs.study.domain.master.entity.Master;
import com.heon9u.rcs.study.repository.MasterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@TestWithDataRollback
class MasterServiceTest {

    @InjectMocks
    private MasterService masterService;

    @Mock
    private MasterRepository masterRepository;

    @Test
    void create() {
        Master master = new Master("test_master");
        CreateMasterRequest cmr = new CreateMasterRequest("test_master");
        master.setId(1L);

        given(masterRepository.save(any(Master.class))).willReturn(master);

        Long id = masterService.create(cmr);

        assertEquals(1L, id);
        verify(masterRepository, times(1)).save(any(Master.class));
    }

    @Test
    void getMaster() {
        Master master = new Master("test_master");
        master.setId(1L);

        given(masterRepository.findById(anyLong())).willReturn(Optional.of(master));

        Master masterTemp = masterService.getMaster(1L);

        assertEquals(master.getMasterName(), masterTemp.getMasterName());
    }

    @Test
    void getMasterList() {
        List<Master> masterList = masterService.getMasterList();
        masterList.add(new Master("test_master1"));
        masterList.add(new Master("test_master2"));

        given(masterRepository.findAll()).willReturn(masterList);

        List<Master> result = masterService.getMasterList();

        assertEquals(result.size(), masterList.size());
    }


}