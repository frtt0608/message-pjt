package com.heon9u.rcs.study.repository;

import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RcsRepository extends JpaRepository<Rcs, Long> {
    Rcs findByRcsName(String rcsName);
}
