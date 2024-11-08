package com.mtarrillo.service.impl;

import com.mtarrillo.model.dao.AppointmentDao;
import com.mtarrillo.model.entity.Appointment;
import com.mtarrillo.model.exepciones.AppointmentConflictException;
import com.mtarrillo.model.exepciones.ResourceNotFoundException;
import com.mtarrillo.service.IAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentImpl implements IAppointment {

    @Autowired
    private AppointmentDao appointmentRepository;


    @Override
    // Método para consultar el historial de citas de un cliente
    public List<Appointment> getClientAppointments(Long clientId) {
        return appointmentRepository.findByClient_Id(clientId);
    }


    // Método para consultar todas las citas de un proveedor en una fecha específica
    @Override
    public List<Appointment> getProviderAppointmentsByDate(Long providerId, LocalDate date) {
        return appointmentRepository.findByProvider_IdAndFecha(providerId,date.atStartOfDay());
    }





    // Método para cancelar una cita
    public void cancelAppointment(Long appointmentId) {
        // Buscamos la cita por ID
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada"));

        // Cambiamos el estado de la cita a "Cancelada" (suponiendo que hay un campo de estado)
        appointment.setEstado("Cancelada");

        // Guardamos los cambios en la base de datos
        appointmentRepository.save(appointment);
    }

    //creamos la cita
    public Appointment createAppointment(Appointment appointment) {
        // Validación si el horario ya está ocupado
        if (appointmentRepository.existsByFechaAndProvider_Id (appointment.getFecha(), appointment.getProvider().getId())) {
            throw new AppointmentConflictException("El proveedor ya tiene una cita en esta fecha.");
        }

        // Guardar la cita en la base de datos
        return appointmentRepository.save(appointment);
    }


}
