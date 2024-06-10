package com.viajes.brayan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.brayan.entidades.Contacto;
import com.viajes.brayan.repository.ContactoRepository;

import java.util.List;

@Service
public class ContactoService {

    private final ContactoRepository contactoRepository;

    @Autowired
    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public Contacto guardarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    public List<Contacto> obtenerTodosLosContactos() {
        return contactoRepository.findAll();
    }

    public Contacto obtenerContactoPorId(String id) {
        return contactoRepository.findById(id).orElse(null);
    }

    public void eliminarContactoPorId(String id) {
        contactoRepository.deleteById(id);
    }
}
