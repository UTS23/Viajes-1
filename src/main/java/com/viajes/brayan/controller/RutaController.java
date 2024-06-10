package com.viajes.brayan.controller;

import com.viajes.brayan.entidades.Ruta;
import com.viajes.brayan.entidades.Usuario;
import com.viajes.brayan.service.RutaService;
import com.viajes.brayan.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rutas")
public class RutaController {
    @Autowired
    private RutaService rutaService;
    private UsuarioService usuarioService;
    

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("ruta", new Ruta());
        return "crear_ruta";
    }

    @PostMapping("/crear")
    public String crearRuta(@ModelAttribute("ruta") @Valid Ruta ruta, BindingResult result) {
        if (result.hasErrors()) {
            return "crear_ruta";
        }
        rutaService.crearRuta(ruta);
        return "redirect:/rutas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable String id, Model model) {
        Optional<Ruta> optionalRuta = rutaService.obtenerRutaPorId(id);
        if (optionalRuta.isPresent()) {
            model.addAttribute("ruta", optionalRuta.get());
            return "editar_ruta";
        } else {
            return "redirect:/rutas";
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizarRuta(@PathVariable String id, @ModelAttribute("ruta") @Valid Ruta ruta) {
        ruta.setId(id);
        rutaService.actualizarRuta(ruta);
        return "redirect:/rutas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRuta(@PathVariable String id) {
        rutaService.eliminarRutaPorId(id);
        return "redirect:/rutas";
    }

    @GetMapping
    public String listarRutas(Model model) {
        model.addAttribute("rutas", rutaService.obtenerTodasLasRutas());
        return "lista_rutas";
    }
    
    @GetMapping("/otra2")
    public String neuva(Model model) {
        model.addAttribute("rutas", rutaService.obtenerTodasLasRutas());
        return "travel"; // Ensure there's a corresponding view named "pero.html"
    }
    
    
    @GetMapping("/otra")
    public String handleOtra(Model model) {
        model.addAttribute("rutas", rutaService.obtenerTodasLasRutas());
        return "pero"; // Ensure there's a corresponding view named "pero.html"
    }
    
   
    //reenvia a otro--------------------------------
    
    @GetMapping("/or")
    public String hand(Model model) {
      
        return "acerca"; // Ensure there's a corresponding view named "pero.html"
    }
    
    
    
   
}


