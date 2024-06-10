package com.viajes.brayan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.brayan.entidades.Travel;
import com.viajes.brayan.repository.TravelRepository;

import java.util.List;

@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    public List<Travel> findAll() {
        return travelRepository.findAll();
    }

    public Travel findById(String id) {
        return travelRepository.findById(id).orElse(null);
    }

    public Travel save(Travel travel) {
        return travelRepository.save(travel);
    }

    public void deleteById(String id) {
        travelRepository.deleteById(id);
    }
}
