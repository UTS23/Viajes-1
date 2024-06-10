package com.viajes.brayan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.viajes.brayan.entidades.Autobus;
import com.viajes.brayan.entidades.Travel;
import com.viajes.brayan.service.AutobusService;
import com.viajes.brayan.service.TravelService;

import java.util.List;

@Controller
public class IndexController {

    private final AutobusService autobusService;
    private final TravelService travelService;

    public IndexController(AutobusService autobusService, TravelService travelService) {
        this.autobusService = autobusService;
        this.travelService = travelService;
    }

    @GetMapping("/privacidad")
    public String createTravem(Model model) {
      
        return "privacidad";  // Nombre de la vista (HTML) del formulario de creación
    }
    
    @GetMapping("/terminos")
    public String createTra2vem(Model model) {
      
        return "terminos";  // Nombre de la vista (HTML) del formulario de creación
    }
    @GetMapping("/")
    public String mostrarPaginaPrincipal(Model model) {
        List<Autobus> autobuses = autobusService.listarAutobuses();
        List<Travel> travels = travelService.findAll();
        model.addAttribute("autobuses", autobuses);
        model.addAttribute("travels", travels);
        return "index";  // Suponiendo que tienes una vista llamada "index.html"
    }
}
