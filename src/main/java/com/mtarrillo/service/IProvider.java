package com.mtarrillo.service;

import com.mtarrillo.model.entity.Appointment;
import com.mtarrillo.model.entity.Availability;
import com.mtarrillo.model.entity.Provider;

import java.time.LocalDateTime;
import java.util.List;

public interface IProvider {

    //crear un proveedor
    Provider createProvider(Provider provider);

    //metodo para consultar la disponibilidad de un proveedor
    List<Availability> getProviderAvailability(Long providerId);

    //metodo para actualizar la disponibilidad de un proveedor
    Availability addAvailability(Long providerId, Availability availability);

    //metodo para ver las citas programadas apra este proveedor
    List<Appointment> getProviderAppointments(Long providerId);

    List<Appointment> getProviderAppointmentsByDate(Long providerId, LocalDateTime date);
}
