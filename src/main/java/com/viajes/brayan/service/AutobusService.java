package com.viajes.brayan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.brayan.entidades.Autobus;
import com.viajes.brayan.repository.AutobusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AutobusService {

    @Autowired
    private AutobusRepository autobusRepository;

    public List<Autobus> listarAutobuses() {
        return autobusRepository.findAll();
    }

    public Autobus crearAutobus(Autobus autobus) {
        return autobusRepository.save(autobus);
    }

    public Autobus editarAutobus(String id, Autobus autobus) {
        autobus.setId(id);
        return autobusRepository.save(autobus);
    }

    public void eliminarAutobus(String id) {
        autobusRepository.deleteById(id);
    }

    public Optional<Autobus> obtenerAutobusPorId(String id) {
        // Utilizamos el método findById proporcionado por Spring Data MongoDB para obtener el autobús por su ID
        return autobusRepository.findById(id);
    }

	
}
