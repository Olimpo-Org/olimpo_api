package com.example.olimpoapi.model;

import jakarta.persistence.Id;
import org.apache.catalina.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "communities")
public class Community {
    @Id
    private String id;

    @Field("community_name")
    private String communityName;

    @Field("users")
    private List<User> users;

    public Community() {
    }

    public Community(String id, String communityName, List<User> users) {
        this.id = id;
        this.communityName = communityName;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
