
package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Tourist;
import com.example.demo.repository.TouristRepository;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public Tourist updateTourist(Long id, Tourist updatedTourist) {

        Tourist existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tourist Not Found"));

        existing.setName(updatedTourist.getName());
        existing.setDestination(updatedTourist.getDestination());
        existing.setContact(updatedTourist.getContact());

        return repository.save(existing);
    }
}
