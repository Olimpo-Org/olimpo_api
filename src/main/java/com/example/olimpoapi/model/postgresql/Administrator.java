package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "administrador")
public class Administrator {

    @Id
    @Column(name = "id")
    private Long id;

    @NotNull(message = "CustomerId cannot be null")
    @Column(name = "customer_cpf")
    private String customerCpf;

    @NotNull(message = "CommunityId cannot be null")
    @Column(name = "community_id")
    private Long communityId;

    public Administrator() {
    }

    public Administrator(Long id, String customerCpf, Long communityId) {
        this.id = id;
        this.customerCpf = customerCpf;
        this.communityId = communityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCpf() {
        return customerCpf;
    }

    public void setCustomerCpf(String customerCpf) {
        this.customerCpf = customerCpf;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }
}
