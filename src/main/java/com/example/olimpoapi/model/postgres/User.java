package com.example.olimpoapi.model.postgres;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta")
public class User {
    @Id

    String userId;
    String userEmail;
    String password;
    String phone;
    String profileImage;

    public User(String userId, String userEmail, String password, String phone, String profileImage) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
        this.phone = phone;
        this.profileImage = profileImage;
    }
    public User() {
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String user_email) {
        this.userEmail = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}