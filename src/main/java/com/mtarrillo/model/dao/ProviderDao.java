package com.mtarrillo.model.dao;

import com.mtarrillo.model.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProviderDao extends JpaRepository<Provider , Long > {
}
