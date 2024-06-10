package com.viajes.brayan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.viajes.brayan.entidades.Travel;

public interface TravelRepository extends MongoRepository<Travel, String> {
    // Aquí puedes definir métodos de consulta personalizados si es necesario
}
