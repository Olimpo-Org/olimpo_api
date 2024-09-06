package com.example.olimpoapi.repository.redis;

import com.example.olimpoapi.model.redis.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {
}
