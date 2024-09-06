package com.example.olimpoapi.model.redis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;

@RedisHash("Message")
public class Message implements Serializable {

    @Id
    private String id;

    @Indexed
    private String chatId;

    @Indexed
    private String senderId;

    private String senderName;

    private Date sendedAt;

    private String content;

    public Message(String chatId, String senderId, String senderName, Date sendedAt, String content) {
        this.chatId = chatId;
        this.senderId = senderId;
        this.senderName = senderName;
        this.sendedAt = sendedAt;
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
        return sendedAt;
    }

    public void setSendedAt(Date sendedAt) {
        this.sendedAt = sendedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
