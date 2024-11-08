package com.mtarrillo.model.dao;

import com.mtarrillo.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientDao extends JpaRepository<Client , Long> {
}
