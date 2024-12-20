package com.aplicaciones.appweb.security;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SuppressWarnings("unused")
    private String username;
    @SuppressWarnings("unused")
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    // Getters y Setters opcionales
}
