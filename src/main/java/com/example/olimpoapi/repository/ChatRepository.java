package com.example.olimpoapi.repository;

import com.example.olimpoapi.model.mongo.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, String> {
}
