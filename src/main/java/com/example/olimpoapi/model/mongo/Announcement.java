package com.example.olimpoapi.model.mongo;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "announcements")
public class Announcement {
    @Id
    private String id;

    @Field("community_id")
    @NotNull(message = "Community id cannot be null")
    private String communityId;

    @Field("sender_id")
    @NotNull(message = "Sender id cannot be null")
    private String senderId;

    @Field("sender_name")
    private String senderName;

    @Field("images")
    private List<String> images;

    @Field("description")
    @NotNull(message = "Description cannot be null")
    @Max(value = 300, message = "Description cannot be longer than 500 characters")
    private String description;

    @Field("type")
    @NotNull(message = "Type cannot be null")
    private String type;

    @Field("sended_at")
    private Date sendedAt;

    public Announcement() {
    }

    public Announcement(String id, String communityId, String senderId, String senderName,
                        List<String> images, String description, String type, Date sendedAt) {
        this.id = id;
        this.communityId = communityId;
        this.senderId = senderId;
        this.senderName = senderName;
        this.images = images;
        this.description = description;
        this.type = type;
        this.sendedAt = sendedAt;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getSendedAt() {
        return sendedAt;
    }

    public void setSendedAt(Date sendedAt) {
        this.sendedAt = sendedAt;
    }
}

