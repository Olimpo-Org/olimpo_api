package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "advertisement")
public class Advertising {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Description cannot be null")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Divulgation date cannot be null")
    @Column(name = "publication_date")
    private LocalDate divulgationDate;

    @Column(name = "product_category_id")
    private Integer idCategoryProduct;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "plan_id")
    private Long idPlan;

    @Column(name = "image")
    private String imageUrl;

    public Advertising() {
    }

    public Advertising(
            Long id,
            String description,
            LocalDate divulgationDate,
            Integer idCategoryProduct,
            String productName,
            Long userId,
            Long idPlan,
            String imageUrl) {
        this.id = id;
        this.description = description;
        this.divulgationDate = divulgationDate;
        this.idCategoryProduct = idCategoryProduct;
        this.productName = productName;
        this.userId = userId;
        this.idPlan = idPlan;
        this.imageUrl = imageUrl;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Long idPlan) {
        this.idPlan = idPlan;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
