package com.viajes.brayan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.viajes.brayan.entidades.Travel;
import com.viajes.brayan.service.TravelService;

import java.util.List;

@Controller
@RequestMapping("/travels")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping
    public String listTravels(Model model) {
        List<Travel> travels = travelService.findAll();
        model.addAttribute("travels", travels);
        return "lugares";  // Nombre de la vista (HTML) a retornar
    }

    @GetMapping("/new")
    public String createTravelForm(Model model) {
        model.addAttribute("travel", new Travel());
        return "travel-form";  // Nombre de la vista (HTML) del formulario de creación
    }

    @PostMapping
    public String createTravel(@ModelAttribute Travel travel) {
        travelService.save(travel);
        return "redirect:/travels";
    }

    @GetMapping("/edit/{id}")
    public String editTravelForm(@PathVariable String id, Model model) {
        Travel travel = travelService.findById(id);
        model.addAttribute("travel", travel);
        return "travel-form";  // Nombre de la vista (HTML) del formulario de edición
    }

    @PostMapping("/edit/{id}")
    public String updateTravel(@PathVariable String id, @ModelAttribute Travel travel) {
        travelService.save(travel);
        return "redirect:/travels";
    }

    @GetMapping("/delete/{id}")
    public String deleteTravel(@PathVariable String id) {
        travelService.deleteById(id);
        return "redirect:/travels";
    }
}
