package com.viajes.brayan.service;

import com.viajes.brayan.entidades.Ruta;
import com.viajes.brayan.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaService {
    @Autowired
    private RutaRepository rutaRepository;

    public Ruta crearRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public List<Ruta> obtenerTodasLasRutas() {
        return rutaRepository.findAll();
    }

    public Optional<Ruta> obtenerRutaPorId(String id) {
        return rutaRepository.findById(id);
    }

    public void eliminarRutaPorId(String id) {
        rutaRepository.deleteById(id);
    }

    public Ruta actualizarRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }
}
