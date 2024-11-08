package com.mtarrillo.controller;

import com.mtarrillo.model.entity.User;
import com.mtarrillo.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    //inyectamos nuestro servicio
    @Autowired
    private IUser userService;


    //creando el usuario
    @Transactional
    @PostMapping
    public User create(@RequestBody User user) {

        return userService.save(user);

    }







}
