package com.example.olimpoapi.repository.accessFlow;

import com.example.olimpoapi.model.postgresql.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    boolean existsByCustomerCpf(String customerCpf);
    Optional<Administrator> findByCustomerCpfAndCommunityId(String customerCpf, Long communityId);
}
