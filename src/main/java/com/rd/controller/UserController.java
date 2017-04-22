package com.rd.controller;

import com.rd.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableResourceServer
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "{emailId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDetails sayHello(@PathVariable String emailId) {
       UserDetails userDetails = userDetailsService.loadUserByUsername(emailId);
       return userDetails;
    }

}
