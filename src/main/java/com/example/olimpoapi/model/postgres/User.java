package com.example.olimpoapi.model.postgres;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta")
public class User {
    @Id

    String user_id;
    String user_email;
    String password;
    String phone;
    String profile_image;

    public User(String user_id, String user_email, String password, String phone, String profile_image) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.password = password;
        this.phone = phone;
        this.profile_image = profile_image;
    }
    public User() {
    }
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
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

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}