package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Community name cannot be null")
    @Column(name = "nome")
    private String name;

    @NotNull(message = "Initial activity date cannot be null")
    @Column(name = "data_inicio_atividade")
    private LocalDate initialActivityDate;

    @NotNull(message = "Neighborhood cannot be null")
    @Column(name = "bairro")
    private String neighborhood;

    @NotNull(message = "Id region cannot be null")
    @Column(name = "id_regiao")
    private Integer idRegion;

    public Community() {
    }
    public Community(
            Long id,
            String name,
            LocalDate initialActivityDate,
            String neighborhood,
            Integer idRegion) {
        this.id = id;
        this.name = name;
        this.initialActivityDate = initialActivityDate;
        this.neighborhood = neighborhood;
        this.idRegion = idRegion;
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

    public LocalDate getInitialActivityDate() {
        return initialActivityDate;
    }

    public void setInitialActivityDate(LocalDate initialActivityDate) {
        this.initialActivityDate = initialActivityDate;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }
}
