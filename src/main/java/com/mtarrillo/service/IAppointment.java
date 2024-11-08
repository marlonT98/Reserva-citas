package com.mtarrillo.service;

import com.mtarrillo.model.entity.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IAppointment {


    // Método para consultar el historial de citas de un cliente
     List<Appointment> getClientAppointments(Long clientId);

    // Método para consultar todas las citas de un proveedor en una fecha específica
    List<Appointment> getProviderAppointmentsByDate(Long providerId, LocalDate date);

    // Método para cancelar una cita
     void cancelAppointment(Long appointmentId);

    //creamos la cita
    Appointment createAppointment(Appointment appointment);

    //boolean existsByFechaAndProvider_Id(LocalDateTime fecha, Long providerId);

}
