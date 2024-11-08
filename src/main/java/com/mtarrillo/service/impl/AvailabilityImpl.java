package com.mtarrillo.service.impl;

import com.mtarrillo.model.dao.AvailbilityDao;
import com.mtarrillo.model.dao.ProviderDao;
import com.mtarrillo.model.entity.Availability;
import com.mtarrillo.model.entity.Provider;
import com.mtarrillo.model.exepciones.ResourceNotFoundException;
import com.mtarrillo.service.IAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityImpl implements IAvailability {


   //implementamos nuestros repositorios
    @Autowired
    private ProviderDao providerRepository;  // repositorio proveedor

     @Autowired
    private AvailbilityDao availabilityRepository; //reoisitorio disponibilidad



    // Método para añadir disponibilidad a un proveedor
    @Override
    public Availability addAvailability(Long providerId, Availability availability) {

        //buscamos al proveedor
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado"));


        // Asignamos el proveedor a la disponibilidad
        availability.setProvider(provider);

        return availabilityRepository.save(availability);
    }
    // Método para obtener disponibilidad de un proveedor
    public List<Availability> getAvailabilityByProvider(Long providerId) {
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado"));

        return availabilityRepository.findByProvider(provider);
    }

    // Método para actualizar la disponibilidad de un proveedor
    public Availability updateAvailability(Long availabilityId, Availability availabilityDetails) {

        Availability availability = availabilityRepository.findById(availabilityId)
                .orElseThrow(() -> new ResourceNotFoundException("Disponibilidad no encontrada"));

        availability.setDia(availabilityDetails.getDia());
        availability.setHoraInicio(availabilityDetails.getHoraInicio());
        availability.setHoraFin(availabilityDetails.getHoraFin());

        return availabilityRepository.save(availability);
    }



}
