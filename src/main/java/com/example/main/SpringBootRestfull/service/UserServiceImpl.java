package com.example.main.SpringBootRestfull.service;

import com.example.main.SpringBootRestfull.entities.User;
import com.example.main.SpringBootRestfull.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices
    {
        @Autowired
        private UserRepositories userRepositories;
        @Override
        public User create(User user)
        {
            return userRepositories.save(user);
        }

        @Override
        public List<User> getAllusers() {

            return userRepositories.findAll();
        }

        @Override
        public Optional<User> getUserDetails(int id) {
            return userRepositories.findById(id);
        }

        @Override
        public User updateUserDetails(int id, User newUser) {
            User userData = userRepositories.findById(id).orElse(null);
            if(userData != null)
            {
               return userRepositories.save(newUser);
            }
             throw new RuntimeException("User not found with id: "+id );
        }

        @Override
        public void deleteUser(int id)
        {
            userRepositories.deleteById(id);
        }


    }
