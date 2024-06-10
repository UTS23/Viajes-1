package com.viajes.brayan.repository;

import com.viajes.brayan.entidades.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompraRepository extends MongoRepository<Compra, String> {
    List<Compra> findByUsuarioId(String usuarioId);
}
