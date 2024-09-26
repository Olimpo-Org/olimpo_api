package com.example.olimpoapi.repository.messageFlow;

import com.example.olimpoapi.model.mongo.Message;
import com.example.olimpoapi.utils.IdGenerator;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepository {

    private final MongoTemplate mongoTemplate;

    public MessageRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Message> getFromChatOrderBySentAtAsc(String chatId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("chatId").is(chatId));
        query.with(Sort.by(Sort.Direction.ASC, "sentAt"));
        return mongoTemplate.find(query, Message.class);
    }

    public Message create(Message message) {
        IdGenerator idGenerator = new IdGenerator();
        message.setMessageId(idGenerator.generateId());
        return mongoTemplate.save(message);
    }

    public boolean verifyIfMessageExists(String messageId) {
        return mongoTemplate.exists(Query.query(Criteria.where("messageId").is(messageId)), Message.class);
    }

    public Message delete(String messageId) {
        return mongoTemplate.findAndRemove(Query.query(Criteria.where("messageId").is(messageId)), Message.class);
    }

}

