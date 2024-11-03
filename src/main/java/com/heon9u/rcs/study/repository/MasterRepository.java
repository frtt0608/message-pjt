package com.heon9u.rcs.study.repository;

import com.heon9u.rcs.study.domain.master.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterRepository extends JpaRepository<Master, Long> {
    Master findByMasterName(String masterName);
}
