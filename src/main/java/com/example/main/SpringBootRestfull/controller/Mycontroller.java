package com.example.main.SpringBootRestfull.controller;

import com.example.main.SpringBootRestfull.entities.User;
import com.example.main.SpringBootRestfull.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Mycontroller {
    @Autowired
    private UserServices userServices;
@PostMapping("/user")
    public User adduserdetails(@RequestBody User user){
    return userServices.create(user);
}
@GetMapping("/user")
public List<User> getAllUserDetails()
{
    return userServices.getAllusers();
}
@GetMapping("/user/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable int id)
    {
        User user = userServices.getUserDetails(id).orElse(null);
        if(user != null)
        {
           return ResponseEntity.ok().body(user);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUserDetails (@PathVariable int id, @RequestBody User user)
    {
        User updatedUser = userServices.updateUserDetails(id, user);
        if(updatedUser != null)
        {
            return ResponseEntity.ok(updatedUser);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id )
    {
        userServices.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
