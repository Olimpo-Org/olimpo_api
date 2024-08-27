package com.example.olimpoapi.repository;

import com.example.olimpoapi.model.redis.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, String> {
}
