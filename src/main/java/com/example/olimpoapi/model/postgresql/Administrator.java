package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name = "administrador")
public class Administrator {

    private Long id;

    @NotNull(message = "CustomerId cannot be null")
    private String customerId;

    @NotNull(message = "CommunityId cannot be null")
    private String communityId;
}
