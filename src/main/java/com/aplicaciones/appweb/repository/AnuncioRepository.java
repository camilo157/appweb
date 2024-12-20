package com.aplicaciones.appweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aplicaciones.appweb.model.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
    // Métodos de consulta personalizados, si es necesario
}