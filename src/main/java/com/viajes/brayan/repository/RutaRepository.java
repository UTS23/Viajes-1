package com.viajes.brayan.repository;

import com.viajes.brayan.entidades.Ruta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends MongoRepository<Ruta, String> {
}
