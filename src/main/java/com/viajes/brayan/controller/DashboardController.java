package com.viajes.brayan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Esto asume que tienes un archivo HTML llamado "dashboard.html" en tu carpeta de recursos estáticos
    }
}
