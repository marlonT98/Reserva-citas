package com.mtarrillo.controller;


import com.mtarrillo.model.entity.Appointment;
import com.mtarrillo.model.entity.Provider;
import com.mtarrillo.service.IProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProviderController {

    @Autowired
    private IProvider providerService;

    // Endpoint para registrar un nuevo proveedor
    @PostMapping
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {

        //creamos al proveedor
        Provider createdProvider = providerService.createProvider(provider);

        //mostramos al proveedor
        return ResponseEntity.ok(createdProvider);

    }

    // Endpoint para consultar citas programadas de un proveedor en una fecha específica
    @GetMapping("/{providerId}/citas")
    public ResponseEntity<List<Appointment>> getProviderAppointments(
            @PathVariable Long providerId, @RequestParam LocalDateTime date) {
        List<Appointment> appointments = providerService.getProviderAppointmentsByDate(providerId, date);
        return ResponseEntity.ok(appointments);
    }


}
