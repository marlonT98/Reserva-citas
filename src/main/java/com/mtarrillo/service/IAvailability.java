package com.mtarrillo.service;

import com.mtarrillo.model.entity.Availability;

import java.util.List;

public interface IAvailability {

    // Método para añadir disponibilidad a un proveedor
    Availability addAvailability(Long providerId, Availability availability);


    // Método para obtener disponibilidad de un proveedor
    List<Availability> getAvailabilityByProvider(Long providerId);


    // Método para actualizar la disponibilidad de un proveedor
     Availability updateAvailability(Long availabilityId, Availability availabilityDetails);

}
