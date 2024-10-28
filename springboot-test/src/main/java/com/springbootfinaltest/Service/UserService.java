package com.springbootfinaltest.Service;

import com.springbootfinaltest.Entity.Posts;
import com.springbootfinaltest.Entity.User;
import com.springbootfinaltest.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User saveDetails(User user){
        user.setRegister_time(String.valueOf(new Date()));
        user.setIs_admin("0");
        return userRepo.save(user);
    }

    public List<User> getAllDetails(){
        return userRepo.findAll();
    }

    public User getDetailsById(int id){
        return userRepo.findById(id);
    }

    public User getDetailsByEmail(String email){
        User user =  userRepo.findByEmail(email);
        return  user;
    }

    public List<User> viewUsers(int id){
        User user = userRepo.findById(id);
        if(user !=null && (user.getIs_admin().equals("1"))){
            List<User> all = userRepo.findAll();
            return all;
        }
       return null;
    }


}
