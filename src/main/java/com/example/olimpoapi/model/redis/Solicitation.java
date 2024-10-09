package com.example.olimpoapi.model.redis;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("solicitation")
public class Solicitation {
    private Long id;
    private String communityId;
    private String userId;
    private String userName;
    private String userUrlImage;

    public Solicitation(
            Long id,
            String communityId,
            String userId,
            String userName,
            String userUrlImage) {
        this.id = id;
        this.communityId = communityId;
        this.userId = userId;
        this.userName = userName;
        this.userUrlImage = userUrlImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserUrlImage() {
        return userUrlImage;
    }

    public void setUserUrlImage(String userUrlImage) {
        this.userUrlImage = userUrlImage;
    }
}
