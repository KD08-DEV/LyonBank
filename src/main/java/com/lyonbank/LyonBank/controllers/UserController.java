package com.lyonbank.LyonBank.controllers;

import com.lyonbank.LyonBank.dao.UserDao;
import com.lyonbank.LyonBank.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
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
    public List<User> getUsers(){
        return userDao.getUsers();
    }


    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){
         userDao.register(user);
    }


    @RequestMapping(value = "api/users", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {userDao.delete(id);}

}
