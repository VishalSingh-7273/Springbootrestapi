package com.example.main.SpringBootRestfull.service;

import com.example.main.SpringBootRestfull.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserServices
{
    public User create(User user);
    public List<User> getAllusers();
    public Optional<User> getUserDetails(int id);
    public User updateUserDetails(int id, User user);
    public void deleteUser(int id);
}
