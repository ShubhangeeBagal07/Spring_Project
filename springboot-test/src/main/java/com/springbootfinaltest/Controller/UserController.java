package com.springbootfinaltest.Controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.springbootfinaltest.Entity.User;
import com.springbootfinaltest.Service.UserService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/showData")
    public User postDetails(@RequestBody User user){
       return userService.saveDetails(user);
    }
    @GetMapping("/getData")
    public List<User> getDetails(){
      return userService.getAllDetails();
    }
    @GetMapping("/getUserDataById/{id}")
    public User fetchDetailsById(@PathVariable int id){
        return userService.getDetailsById(id);
    }

    @GetMapping("/")
    public String result(){
        return "Home Page";
    }

}
