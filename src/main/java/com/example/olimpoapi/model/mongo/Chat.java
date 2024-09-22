package com.example.olimpoapi.model.mongo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "chats")
public class Chat {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Field("chat_id")
    private String chatId;

    @NotNull(message = "Community id cannot be null")
    @Field("community_id")
    private String communityId;

    @NotNull(message = "Users ids cannot be null")
    @Field("users_ids")
    private List<String> usersIds;

    @NotNull(message = "Chat name cannot be null")
    @Field("chat_name")
    private String chatName;

    @NotNull(message = "Chat owners cannot be null")
    @Field("chat_owners")
    private List<String> chatOwners;

    @NotNull(message = "Channel type cannot be null")
    @Field("channel_type")
    private String channelType;

    @Field("created_at")
    private Date createdAt;

    public Chat() {
    }

    public Chat(String id, String chatId, String communityId, List<String> usersIds, String chatName, List<String> chatOwners, Date createdAt, String channelType) {
        this.id = id;
        this.chatId = chatId;
        this.communityId = communityId;
        this.usersIds = usersIds;
        this.chatName = chatName;
        this.chatOwners = chatOwners;
        this.createdAt = createdAt;
        this.channelType = channelType;
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

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public List<String> getUsersIds() {
        return usersIds;
    }

    public void setUsersIds(List<String> usersIds) {
        this.usersIds = usersIds;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public List<String> getChatOwners() {
        return chatOwners;
    }

    public void setChatOwners(List<String> chatOwners) {
        this.chatOwners = chatOwners;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
}
