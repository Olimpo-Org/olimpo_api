package com.example.olimpoapi.model.mongo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

@Document(collection = "publications")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull(message = "Community id cannot be null")
    @Field("community_id")
    private String communityId;

    @NotNull(message = "Sender id cannot be null")
    @Field("sender_id")
    private String senderId;

    @Field("sender_name")
    private String senderName;

    @Field("images")
    private List<String> images;

    @NotNull(message = "Description cannot be null")
    @Max(message = "Description cannot be longer than 500 characters", value = 300)
    @Field("description")
    private String description;

    @Field("likes")
    private List<String> likes;

    @Field("comments")
    private List<Comment> comments;

    @NotNull(message = "Tag cannot be null")
    @Field("tag")
    private String tag;

    public Publication(String communityId, String senderId, String senderName, List<String> images,
                       String description, List<String> likes, List<Comment> comments, String tag) {
        this.communityId = communityId;
        this.senderId = senderId;
        this.senderName = senderName;
        this.images = images;
        this.description = description;
        this.likes = likes;
        this.comments = comments;
        this.tag = tag;
    }

    public Publication() {
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

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}
