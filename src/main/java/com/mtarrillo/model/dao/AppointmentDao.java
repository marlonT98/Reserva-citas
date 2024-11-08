package com.mtarrillo.model.dao;

import com.mtarrillo.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentDao extends JpaRepository<Appointment , Long > {
    // Buscamos las citas de un cliente por su ID
    List<Appointment> findByClient_Id(Long clientId);

    // Buscamos las citas de un proveedor por su ID
    List<Appointment> findByProvider_Id(Long providerId);

    // Método para encontrar citas por proveedor y fecha
    List<Appointment> findByProvider_IdAndFecha(Long providerId, LocalDateTime fecha);

    // Método para verificar si ya existe una cita en una fecha para un proveedor específico
    boolean existsByFechaAndProvider_Id(LocalDateTime fecha, Long providerId);

    // Método para buscar citas de un proveedor entre un rango de fechas
    List<Appointment> findByProvider_IdAndFechaBetween(Long providerId, LocalDateTime startDate, LocalDateTime endDate);



}

