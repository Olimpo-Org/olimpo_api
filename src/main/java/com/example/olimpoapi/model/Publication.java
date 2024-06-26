package com.example.olimpoapi.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "your_collection_name")
public class Publication {

    @Field("community_id")
    private String communityId;

    @Field("sender_id")
    private String senderId;

    @Field("sender_name")
    private String senderName;

    @Field("images")
    private List<String> images; // Assuming Base64 images are stored as strings

    @Field("description")
    private String description;

    @Field("likes")
    private List<String> likes;

    @Field("comments")
    private List<Comment> comments;


    public Publication(String communityId, String senderId, String senderName, List<String> images,
                       String description, List<String> likes, List<Comment> comments) {
        this.communityId = communityId;
        this.senderId = senderId;
        this.senderName = senderName;
        this.images = images;
        this.description = description;
        this.likes = likes;
        this.comments = comments;
    }

    public Publication() {
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
}
