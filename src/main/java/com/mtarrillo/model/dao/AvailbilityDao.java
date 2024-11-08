package com.mtarrillo.model.dao;

import com.mtarrillo.model.entity.Availability;
import com.mtarrillo.model.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailbilityDao extends JpaRepository<Availability , Long> {
    //metodo personalizado
    //metodo que permite obtener
    // /la lista de horarios disponibles para un proveedor específico usando su providerId
    List<Availability> findByProvider_Id(Long providerId);

    // Método para encontrar todas las disponibilidades de un proveedor específico
    List<Availability> findByProvider(Provider provider);





}
