package com.heon9u.rcs.study.repository;

import com.heon9u.rcs.study.domain.send.entity.Send;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendRepository extends JpaRepository<Send, Long> {
}
