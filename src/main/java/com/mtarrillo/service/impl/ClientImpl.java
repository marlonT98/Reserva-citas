package com.mtarrillo.service.impl;

import com.mtarrillo.model.dao.AppointmentDao;
import com.mtarrillo.model.dao.ClientDao;
import com.mtarrillo.model.entity.Appointment;
import com.mtarrillo.model.entity.Client;
import com.mtarrillo.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientImpl implements IClient {

    @Autowired
    private ClientDao clientRepository;

    @Autowired
    private AppointmentDao appointmentRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save( client );
    }

    @Override
    public List<Appointment> getClientAppointments(Long id) {
        return appointmentRepository.findByClient_Id(id);
    }
}
