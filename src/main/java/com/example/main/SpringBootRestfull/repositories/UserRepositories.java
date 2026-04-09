package com.example.main.SpringBootRestfull.repositories;

import com.example.main.SpringBootRestfull.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer>
{

}
