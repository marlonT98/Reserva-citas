package com.mtarrillo.service.impl;

import com.mtarrillo.model.dao.UserDao;
import com.mtarrillo.model.entity.User;
import com.mtarrillo.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserImpl  implements IUser {

    //inyectamos nuestro repositorio
    @Autowired
    private UserDao userDao;



    @Override
    public User save(User user) {
        return userDao.save( user);
    }




}
