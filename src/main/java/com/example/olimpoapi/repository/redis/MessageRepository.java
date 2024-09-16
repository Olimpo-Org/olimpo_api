package com.example.olimpoapi.repository.redis;

import com.example.olimpoapi.model.redis.Message;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, String> {
    List<Message> findAllByChatIdOrderBySendedAtAsc(String chatId);
}

