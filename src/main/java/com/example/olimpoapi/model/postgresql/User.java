package com.example.olimpoapi.model.postgresql;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "cliente")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Email cannot be null")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Column(name = "senha")
    private String password;

    @NotNull(message = "Name cannot be null")
    @Column(name = "nome")
    private String name;

    @NotNull(message = "Sobrenome cannot be null")
    @Column(name = "sobrenome")
    private String lastName;

    @NotNull(message = "CPF cannot be null")
    @Size(min = 11, max = 11, message = "CPF must be exactly 11 characters")
    @Column(name = "cpf")
    private String cpf;

    @NotNull(message = "Id gender cannot be null")
    @Column(name = "id_genero")
    private Integer idGender;

    @NotNull(message = "Date of birth cannot be null")
    @Column(name = "id_principal_interesse")
    private Integer idPrincipalInterest;

    public User() {
    }
    public User(
            Long id,
            String email,
            String password,
            String name,
            String lastName,
            String cpf,
            Integer idGender,
            Integer idPrincipalInterest) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.idGender = idGender;
        this.idPrincipalInterest = idPrincipalInterest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdGender() {
        return idGender;
    }

    public void setIdGender(Integer idGender) {
        this.idGender = idGender;
    }

    public Integer getIdPrincipalInterest() {
        return idPrincipalInterest;
    }

    public void setIdPrincipalInterest(Integer idPrincipalInterest) {
        this.idPrincipalInterest = idPrincipalInterest;
    }
}