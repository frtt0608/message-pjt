package com.heon9u.rcs.study.repository;

import com.heon9u.rcs.study.domain.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
