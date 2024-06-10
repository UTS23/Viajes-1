package com.viajes.brayan.controller;

import com.viajes.brayan.entidades.Compra;
import com.viajes.brayan.entidades.Ruta;
import com.viajes.brayan.service.CompraService;
import com.viajes.brayan.service.RutaService;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private RutaService rutaService;


    @GetMapping("/compra/{compraId}")
    public String verCompra(@PathVariable String compraId, Model model) {
        Optional<Compra> compraOpt = compraService.obtenerCompraPorId(compraId);

        if (compraOpt.isPresent()) {
            Compra compra = compraOpt.get();
            model.addAttribute("compra", compra);
            
            // Obtener información adicional relacionada con el ID de compra y agregarla al modelo
            // Por ejemplo, si quieres mostrar detalles de la ruta asociada a esta compra:
            Optional<Ruta> rutaOpt = rutaService.obtenerRutaPorId(compra.getRutaId());
            if (rutaOpt.isPresent()) {
                Ruta ruta = rutaOpt.get();
                model.addAttribute("ruta", ruta);
            }
            
            return "detallesCompra";
        } else {
            model.addAttribute("error", "Compra no encontrada");
            return "error";
        }
    }

    
    @GetMapping("/detalles-compra/{compraId}")
    public String mostrarDetallesCompra(@PathVariable String compraId, Model model) {
        Optional<Compra> compraOpt = compraService.obtenerCompraPorId(compraId);

        if (compraOpt.isPresent()) {
            Compra compra = compraOpt.get();
            model.addAttribute("compra", compra);
            return "detallesCompra";
        } else {
            model.addAttribute("error", "Compra no encontrada");
            return "error";
        }
    }

    @PostMapping("/realizar")
    public String realizarCompra(@ModelAttribute Compra compra, @RequestParam String usuarioId,
            @RequestParam String rutaId) {
        compra.setUsuarioId(usuarioId);
        compra.setRutaId(rutaId);
        compra.setFechaCompra(new Date());
        compraService.realizarCompra(compra);
        return "redirect:/compras/compra/" + compra.getId();
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCompra(Model model) {
        model.addAttribute("compra", new Compra());
        return "formularioCompra";
    }
}

