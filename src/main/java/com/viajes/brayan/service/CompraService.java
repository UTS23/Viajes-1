package com.viajes.brayan.service;

import com.viajes.brayan.entidades.Compra;
import com.viajes.brayan.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> obtenerComprasPorUsuarioId(String usuarioId) {
        return compraRepository.findByUsuarioId(usuarioId);
    }

    public void realizarCompra(Compra compra) {
        compraRepository.save(compra);
    }

    public Optional<Compra> obtenerCompraPorId(String compraId) {
        return compraRepository.findById(compraId);
    }
}

