package com.viajes.brayan.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viajes.brayan.entidades.Contacto;
import com.viajes.brayan.service.ContactoService;

import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/con")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/contacto")
    public String mostrarFormularioContacto(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "formulario_contacto";
    }

    @GetMapping("/gracias")
    public String mostrarPaginaGracias(Model model) {
        return "gracias";
    }

    @GetMapping("/listar")
    public String listarContactos(Model model) {
    	 List<Contacto> contactos = contactoService.obtenerTodosLosContactos();
    	    model.addAttribute("contactos", contactos);
    	    return "lista_contactos";
    }
    
  
    
    @PostMapping("/contacto")
    public String procesarFormularioContacto(@Valid @ModelAttribute("contacto") Contacto contacto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Manejar errores de validación, si los hay
            return "formulario_contacto";
        } else {
            contactoService.guardarContacto(contacto);
            return "redirect:/con/gracias";
        }
    }

}
