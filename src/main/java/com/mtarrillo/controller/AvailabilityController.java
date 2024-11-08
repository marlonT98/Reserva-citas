package com.mtarrillo.controller;

import com.mtarrillo.model.dao.AvailbilityDao;
import com.mtarrillo.model.entity.Availability;
import com.mtarrillo.service.IAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores/{providerId}/disponibilidad")
public class AvailabilityController {


    @Autowired
    private IAvailability availabilityService;

    // Endpoint para establecer la disponibilidad de un proveedor
    @PostMapping
    public ResponseEntity<Availability> addAvailability(
            @PathVariable Long providerId, @RequestBody  Availability availability) {

        Availability createdAvailability = availabilityService.addAvailability(providerId, availability);
        return ResponseEntity.ok(createdAvailability);

    }

    // Endpoint para consultar la disponibilidad de un proveedor
    @GetMapping
    public ResponseEntity<List<Availability>> getAvailabilityByProvider(@PathVariable Long providerId) {
        List<Availability> availabilities = availabilityService.getAvailabilityByProvider(providerId);
        return ResponseEntity.ok(availabilities);
    }

    // Endpoint para actualizar disponibilidad de un proveedor
    @PutMapping("/{availabilityId}")
    public ResponseEntity<Availability> updateAvailability(
            @PathVariable Long availabilityId, @RequestBody Availability availabilityDetails) {
        Availability updatedAvailability = availabilityService.updateAvailability(availabilityId, availabilityDetails);
        return ResponseEntity.ok(updatedAvailability);
    }



}
