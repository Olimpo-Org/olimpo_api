package com.example.olimpoapi.repository.jpa;

import com.example.olimpoapi.model.postgres.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
//    List<User> findByCommunityId(String communityId);

    Optional<User> findByUserEmail(String email);
}
