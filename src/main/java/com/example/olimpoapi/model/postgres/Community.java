package com.example.olimpoapi.model.postgres;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.catalina.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Entity
@Table(name = "community")
public class Community {
    @Id
    private String id;

    private String communityName;

//    private List<User> users;

    public Community() {
    }

    public Community(String id, String communityName, List<User> users) {
        this.id = id;
        this.communityName = communityName;
//        this.users = users;
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

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
}
