package com.lyonbank.LyonBank.controllers;

import com.lyonbank.LyonBank.dao.UserDao;
import com.lyonbank.LyonBank.dto.LoginDTO;
import com.lyonbank.LyonBank.models.User;
import com.lyonbank.LyonBank.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtill;
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody LoginDTO loginDTO) {
        System.out.println("Checking user "+ loginDTO.getPassword()+ loginDTO.getEmail());
        User user = new User();
        
        user.setEmail(loginDTO.getEmail());
        user.setPassword(loginDTO.getPassword());

        User userLogged = userDao.checkInfo(user);
        if(userLogged != null){
           String tokenJwt = jwtUtill.create(String.valueOf(userLogged.getId()),userLogged.getEmail());
           System.out.println("all good with "+userLogged.getPassword()+userLogged.getEmail()+userLogged.getId());
           return tokenJwt;
        }
        System.out.println("ERROR");
        return "FAIL";
    }
}
