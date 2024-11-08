package com.mtarrillo.service;

import com.mtarrillo.model.entity.Appointment;
import com.mtarrillo.model.entity.Client;

import java.util.List;

public interface IClient  {

    Client save ( Client client);
    List<Appointment> getClientAppointments(Long id);

}
