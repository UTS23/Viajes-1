package com.viajes.brayan.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.viajes.brayan.entidades.Autobus;

public interface AutobusRepository extends MongoRepository<Autobus, String> {
}
