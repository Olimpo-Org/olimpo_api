package com.example.olimpoapi.repository;

import com.example.olimpoapi.model.postgres.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
