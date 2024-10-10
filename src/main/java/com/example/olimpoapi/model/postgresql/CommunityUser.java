package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Table(name = "community_customer")
public class CommunityUser {
    @NotNull(message = "CustomerId cannot be null")
    @Column(name = "customer_id")
    private String customerId;

    @NotNull(message = "CommunityId cannot be null")
    @Column(name = "community_id")
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
