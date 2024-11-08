package com.mtarrillo.controller;

import com.mtarrillo.model.entity.Appointment;
import com.mtarrillo.service.IAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class AppointmentController {

    @Autowired
    private IAppointment appointmentService;

    // Endpoint para crear una nueva cita
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return ResponseEntity.ok(createdAppointment);
    }

    // Endpoint para cancelar una cita
    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para consultar todas las citas de un cliente
    @GetMapping("/clientes/{clientId}")
    public ResponseEntity<List<Appointment>> getClientAppointments(@PathVariable Long clientId) {
        List<Appointment> appointments = appointmentService.getClientAppointments(clientId);
        return ResponseEntity.ok(appointments);
    }

    // Endpoint para consultar todas las citas de un proveedor en una fecha específica
    @GetMapping("/proveedores/{providerId}")
    public ResponseEntity<List<Appointment>> getProviderAppointmentsByDate(
            @PathVariable Long providerId,  @RequestParam("date") LocalDate date) {
        List<Appointment> appointments = appointmentService.getProviderAppointmentsByDate(providerId, date);
        return ResponseEntity.ok(appointments);
    }
}
