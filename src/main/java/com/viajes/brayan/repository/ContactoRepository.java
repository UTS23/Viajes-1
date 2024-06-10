package com.viajes.brayan.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viajes.brayan.entidades.Contacto;

@Repository
public interface ContactoRepository extends MongoRepository<Contacto, String> {
}
