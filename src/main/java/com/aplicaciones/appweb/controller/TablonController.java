package com.aplicaciones.appweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aplicaciones.appweb.model.Anuncio;

import jakarta.servlet.http.HttpSession;

@Controller
public class TablonController {
private List<Anuncio> anuncios = new ArrayList<>();
    @SuppressWarnings("unused")
    private String nombreUsuario;

    @GetMapping("/")
    public String inicio(Model model, HttpSession session) {
        if (session.getAttribute("bienvenida") == null) {
            model.addAttribute("mensaje", "¡Bienvenido!");
            session.setAttribute("bienvenida", true);
        }
        model.addAttribute("anuncios", anuncios);
        return "index";
    }

    @GetMapping("/nuevo")
    public String nuevoAnuncio(Model model, HttpSession session) {
        model.addAttribute("anuncio", new Anuncio());
        model.addAttribute("nombreUsuario", session.getAttribute("nombreUsuario"));
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardarAnuncio(@ModelAttribute Anuncio anuncio, HttpSession session) {
        anuncios.add(anuncio);
        session.setAttribute("nombreUsuario", anuncio.getNombre());
        return "redirect:/exito";
    }

    @GetMapping("/exito")
    public String exito() {
        return "exito";
    }

    @GetMapping("/detalle/{index}")
    public String detalleAnuncio(@PathVariable int index, Model model) {
        model.addAttribute("anuncio", anuncios.get(index));
        return "detalle";
    }
}
