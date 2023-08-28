package com.lyonbank.LyonBank.controllers;

import com.lyonbank.LyonBank.dao.UserDao;
import com.lyonbank.LyonBank.models.User;
import com.lyonbank.LyonBank.util.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping(value = "api/users{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("Kevin");
        user.setLastName("De Leon");
        user.setEmail("kevinjosexd@gmail.com");
        user.setPhone("8092552121");
        return user;
    }

     @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers(@RequestHeader(value = "Authorization") String token){
        String userID = jwtUtil.getKey(token);
        if(!validateToken(token)){
            return null;
        }
        return userDao.getUsers();
    }
    private boolean validateToken(String token){
        String userId = jwtUtil.getKey(token);
        return userId != null;
    }


    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){
        //Security of password
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024,1,user.getPassword());
        user.setPassword(hash);
         userDao.register(user);
    }

    @RequestMapping(value = "api/users", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {userDao.delete(id);}
}
