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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull(message = "Community id cannot be null")
    @Field("community_id")
    private String communityId;

    @NotNull(message = "Users ids cannot be null")
    @Field("users_ids")
    private List<String> usersIds;

    @NotNull(message = "Chat name cannot be null")
    @Field("chat_name")
    private String chatName;

    @Field("created_at")
    private Date createdAt;

    @Field("chat_ower_id")
    private String chatOwnerId;

    @Field("channel_type")
    private String channelType;

    public Chat() {
    }

    public Chat(String id, String communityId, List<String> usersIds, String chatName,
                Date createdAt, String chatOwnerId, String channelType) {
        this.id = id;
        this.communityId = communityId;
        this.usersIds = usersIds;
        this.chatName = chatName;
        this.createdAt = createdAt;
        this.chatOwnerId = chatOwnerId;
        this.channelType = channelType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getChatOwnerId() {
        return chatOwnerId;
    }

    public void setChatOwnerId(String chatOwnerId) {
        this.chatOwnerId = chatOwnerId;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
}
