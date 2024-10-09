package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "advertising")
public class Advertising {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Description cannot be null")
    @Column(name = "descricao")
    private String description;

    @NotNull(message = "Divulgation date cannot be null")
    @Column(name = "data_divulgacao")
    private LocalDate divulgationDate;

    @Column(name = "id_categoria_produto")
    private Integer idCategoryProduct;

    @Column(name = "nome_produto")
    private String productName;

    @Column(name = "id_cliente")
    private Long idClient;

    @Column(name = "id_plano")
    private Long idPlan;

    public Advertising() {
    }

    public Advertising(
            Long id,
            String description,
            LocalDate divulgationDate,
            Integer idCategoryProduct,
            String productName,
            Long idClient,
            Long idPlan) {
        this.id = id;
        this.description = description;
        this.divulgationDate = divulgationDate;
        this.idCategoryProduct = idCategoryProduct;
        this.productName = productName;
        this.idClient = idClient;
        this.idPlan = idPlan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDivulgationDate() {
        return divulgationDate;
    }

    public void setDivulgationDate(LocalDate divulgationDate) {
        this.divulgationDate = divulgationDate;
    }

    public Integer getIdCategoryProduct() {
        return idCategoryProduct;
    }

    public void setIdCategoryProduct(Integer idCategoryProduct) {
        this.idCategoryProduct = idCategoryProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Long idPlan) {
        this.idPlan = idPlan;
    }
}
