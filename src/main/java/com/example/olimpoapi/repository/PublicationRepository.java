package com.example.olimpoapi.repository;

import com.example.olimpoapi.model.mongo.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, String> {
}
