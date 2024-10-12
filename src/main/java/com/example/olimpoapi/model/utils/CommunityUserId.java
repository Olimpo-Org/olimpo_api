package com.example.olimpoapi.model.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CommunityUserId implements Serializable {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "community_id")
    private Long communityId;

    public CommunityUserId() {
    }

    public CommunityUserId(Long customerId, Long communityId) {
        this.customerId = customerId;
        this.communityId = communityId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommunityUserId)) return false;
        CommunityUserId that = (CommunityUserId) o;
        return customerId.equals(that.customerId) && communityId.equals(that.communityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, communityId);
    }
}

