
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Tourist;
import com.example.demo.service.TouristService;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    private static final String VALID_TOKEN = "ABC123";

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTourist(
            @PathVariable Long id,
            @RequestHeader("Token") String token,
            @RequestBody Tourist tourist) {

        // Validate token
        if (!VALID_TOKEN.equals(token)) {
            return ResponseEntity.internalServerError()
                    .body("Invalid Token");
        }

        // Update tourist record
        Tourist updated = service.updateTourist(id, tourist);

        return ResponseEntity.ok("Tourist Updated Successfully");
    }
}
