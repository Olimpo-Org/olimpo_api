package com.example.olimpoapi.model.postgresql;


import com.example.olimpoapi.model.utils.CommunityUserId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "community_customer")
public class CommunityUser {

    @EmbeddedId
    private CommunityUserId id;

    public CommunityUser() {
    }

    public CommunityUser(CommunityUserId id) {
        this.id = id;
    }

    public CommunityUserId getId() {
        return id;
    }

    public void setId(CommunityUserId id) {
        this.id = id;
    }
}

