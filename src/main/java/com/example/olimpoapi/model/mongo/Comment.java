package com.example.olimpoapi.model.mongo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull(message = "Sender id cannot be null")
    @Field("sender_id")
    private String senderId;

    @Field("sender_name")
    private String senderName;

    @NotNull(message = "Content cannot be null")
    @Field("content")
    private String content;

    public Comment() {
    }
    public Comment(String id, String senderId, String senderName, String content) {
        this.id = id;
        this.senderId = senderId;
        this.senderName = senderName;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
