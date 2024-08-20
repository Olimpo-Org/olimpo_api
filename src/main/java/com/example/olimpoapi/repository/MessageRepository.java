package com.example.olimpoapi.repository;

import com.example.olimpoapi.model.mongo.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {
}
