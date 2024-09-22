package com.example.olimpoapi.model.redis;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;

@RedisHash("Message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull(message = "Chat id cannot be null")
    private String chatId;

    @Indexed
    @NotNull(message = "Sender id cannot be null")
    private String senderId;

    @NotNull(message = "Sender name cannot be null")
    private String senderName;

    @NotNull(message = "Content cannot be null")
    @Max(message = "Content cannot be longer than 600 characters", value = 600)
    private String content;

    private Date sentdAt;

    public Message(String chatId, String senderId, String senderName, Date sendedAt, String content) {
        this.chatId = chatId;
        this.senderId = senderId;
        this.senderName = senderName;
        this.sentdAt = sendedAt;
        this.content = content;
    }

    public Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
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

    public Date getSendedAt() {
        return sentdAt;
    }

    public void setSendedAt(Date sendedAt) {
        this.sentdAt = sendedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
