package com.mtarrillo.controller;


import com.mtarrillo.model.entity.Appointment;
import com.mtarrillo.model.entity.Client;
import com.mtarrillo.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //api de tipo rest
@RequestMapping("/api/clientes")
public class ClientController  {

    @Autowired
    private IClient clientService;

    // Endpoint para registrar un nuevo cliente
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {

        //creamos el cliente
        Client createdClient = clientService.save(client );

        //retornamos el cliente creado
        return ResponseEntity.ok(createdClient);

    }

    // Endpoint para consultar el historial de citas de un cliente
    @GetMapping("/{clientId}/citas")
    public ResponseEntity<List<Appointment>> getClientAppointments(@PathVariable Long clientId) {

        //obtenemos la lista de clientes
        List<Appointment> appointments = clientService.getClientAppointments(clientId);

        return ResponseEntity.ok(appointments);
    }

}
