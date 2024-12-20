package com.aplicaciones.appweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aplicaciones.appweb.repository.AnuncioRepository;
import com.aplicaciones.appweb.model.Anuncio;

@RestController
@RequestMapping("/api/anuncios")
public class AnuncioRestController {
    @Autowired
    private AnuncioRepository anuncioRepository;

    @GetMapping
    public List<?> getAllAnuncios() {
        return anuncioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anuncio> obtenerPorId(@PathVariable Long id) {
        Optional<Anuncio> anuncio = anuncioService.findById(id);
        return anuncio.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Anuncio crearAnuncio(@RequestBody Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }
}


