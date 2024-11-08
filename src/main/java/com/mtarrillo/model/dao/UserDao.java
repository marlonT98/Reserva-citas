package com.mtarrillo.model.dao;

import com.mtarrillo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//repositorio
@Repository
public interface UserDao  extends JpaRepository<User , Long > {
}
