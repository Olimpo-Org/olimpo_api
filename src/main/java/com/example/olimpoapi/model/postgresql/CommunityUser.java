package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Table(name = "community_customer")
public class CommunityUser {
    @NotNull(message = "CustomerId cannot be null")
    private String customerId;

    @NotNull(message = "CommunityId cannot be null")
    private String communityId;

    public CommunityUser() {
    }

    public CommunityUser(String customerId, String communityId) {
        this.customerId = customerId;
        this.communityId = communityId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

}
