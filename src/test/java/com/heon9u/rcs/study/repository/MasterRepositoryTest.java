package com.heon9u.rcs.study.repository;

import com.heon9u.rcs.study.domain.master.entity.Master;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MasterRepositoryTest {

    @Autowired
    MasterRepository masterRepository;

    @Test
    void save() {
        Master master = new Master("test_master");
        master.setId(1L);

        Master savedMaster = masterRepository.save(master);

        assertEquals(master.getMasterName(), savedMaster.getMasterName());
    }

}
