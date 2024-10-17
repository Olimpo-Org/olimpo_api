package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "community")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Community name cannot be null")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Start date cannot be null")
    @Column(name = "start_date")
    private Date startDate;

    @NotNull(message = "Neighborhood cannot be null")
    @Column(name = "neighborhood")
    private String neighborhood;

    @NotNull(message = "Region ID cannot be null")
    @Column(name = "region_id")
    private Integer regionId;

    @NotNull(message = "Image cannot be null")
    @Column(name = "image")
    private String imageUrl;

    public Community() {
    }

    public Community(
            Long id,
            String name,
            Date startDate,
            String neighborhood,
            Integer regionId,
            String imageUrl
    ) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.neighborhood = neighborhood;
        this.regionId = regionId;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
