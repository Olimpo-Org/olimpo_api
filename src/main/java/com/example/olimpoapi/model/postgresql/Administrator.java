package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name = "administrador")
public class Administrator {

    @Column(name = "id")
    private Long id;

    @NotNull(message = "CustomerId cannot be null")
    @Column(name = "customer_cpf")
    private String customerCpf;

    @NotNull(message = "CommunityId cannot be null")
    @Column(name = "community_id")
    private String communityId;
}
