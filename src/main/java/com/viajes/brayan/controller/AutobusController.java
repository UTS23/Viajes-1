package com.viajes.brayan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.viajes.brayan.entidades.Autobus;
import com.viajes.brayan.service.AutobusService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/autobuses")
public class AutobusController {

    @Autowired
    private AutobusService autobusService;

    // Mostrar la lista de autobuses
   
    
    @GetMapping("/bus")
    public String listar(Model model) {
        List<Autobus> autobuses = autobusService.listarAutobuses();
        model.addAttribute("autobuses", autobuses);
        return "autobuses";
    }

    // Mostrar el formulario para crear un nuevo autobús
    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("autobus", new Autobus());
        return "new";
    }

    // Manejar la solicitud de creación de un nuevo autobús
    @PostMapping("/crear")
    public String crearAutobus(@ModelAttribute Autobus autobus) {
        autobusService.crearAutobus(autobus);
        return "redirect:/api/autobuses/bus";
    }

    // Mostrar el formulario para editar un autobús existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable String id, Model model) {
        Optional<Autobus> autobus = autobusService.obtenerAutobusPorId(id);
        if (autobus.isPresent()) {
            model.addAttribute("autobus", autobus.get());
            return "editarAutobus";
        } else {
            return "redirect:/api/autobuses";
        }
    }

    // Manejar la solicitud de edición de un autobús existente
    @PostMapping("/editar/{id}")
    public String editarAutobus(@PathVariable String id, @ModelAttribute Autobus autobus) {
        autobusService.editarAutobus(id, autobus);
        return "redirect:/api/autobuses";
    }

    // Manejar la solicitud de eliminación de un autobús
    @PostMapping("/eliminar/{id}")
    public String eliminarAutobus(@PathVariable String id) {
        autobusService.eliminarAutobus(id);
        return "redirect:/api/autobuses/bus";
    }
}

