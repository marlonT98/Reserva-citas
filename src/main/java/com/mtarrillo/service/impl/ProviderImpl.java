package com.mtarrillo.service.impl;

import com.mtarrillo.model.dao.AppointmentDao;
import com.mtarrillo.model.dao.AvailbilityDao;
import com.mtarrillo.model.dao.ProviderDao;
import com.mtarrillo.model.entity.Appointment;
import com.mtarrillo.model.entity.Availability;
import com.mtarrillo.model.entity.Provider;
import com.mtarrillo.service.IProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ProviderImpl  implements IProvider {

    //---inyectamos los repositorios----

    //repositorio del proveedor
    @Autowired
    private ProviderDao providerRepository;

    //repositorio de la disponibilidad
    @Autowired
    private AvailbilityDao availabilityRepository;

    @Autowired
    private AppointmentDao appointmentRepository;


    //creamos un proveedor
    @Override
    public Provider createProvider(Provider provider) {
        return providerRepository.save( provider );
    }

    //metodo para consultar la disponibilidad de un proveedor
    @Override
    public List<Availability> getProviderAvailability(Long providerId) {
        return  availabilityRepository.findByProvider_Id( providerId);
    }

    //metodo para actualizar la disponibilidad de un proveedor
    @Override
    public Availability addAvailability(Long providerId, Availability availability) {

        //creamos un opcional manejamos los errores
        Optional<Provider> providerOptional = providerRepository.findById(providerId);

        //condicion

        if (providerOptional.isPresent()) { //si esta presente

            Provider provider = providerOptional.get(); //obtenemos el proveedor

            availability.setProvider(provider);  // Relaciona la disponibilidad con el proveedor

            return availabilityRepository.save(availability);

        } else {
            throw new RuntimeException("Proveedor no encontrado con el ID: " + providerId);
        }



    }


    //metodo para ver las citas programadas para este proveedor
    @Override
    public List<Appointment> getProviderAppointments(Long providerId) {
        return appointmentRepository.findByProvider_Id(providerId);
    }

    // Método para obtener citas de un proveedor en una fecha específica
    public List<Appointment> getProviderAppointmentsByDate(Long providerId, LocalDateTime date) {
        return appointmentRepository.findByProvider_IdAndFecha(providerId, date);
    }
}
