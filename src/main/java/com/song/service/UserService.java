package com.song.service;

import com.song.entity.User;
import com.song.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Song on 2017/2/15.
 * User业务逻辑
 */
@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;

    public User findUserByName(String name){
        User user = null;
        try{
            user = userRepositoty.findByUserName(name);
        }catch (Exception e){}
        return user;
    }

    public User findUserByName2(String name){
        User user = null;
        try{
            user = userRepositoty.findByName(name);
        }catch (Exception e){}
        return user;
    }

    public User findUserByName3(String name,String password){
        User user = null;
        try{
            user = userRepositoty.findByNameAndPassword(name,password);
        }catch (Exception e){}
        return user;
    }

    public void insertUser(User user){
        userRepositoty.save(user);
    }

    public void insertUser(String name, String password){
        userRepositoty.insertUser(name,password);
    }

}
