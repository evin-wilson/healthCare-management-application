package com.example.project.service;

import com.example.project.Model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ApplicationUserService {

    @Autowired
    ApplicationUserRepository repo;

    public void saveUsers(ApplicationUser user) {
        repo.save(user);
    }

    public Optional<ApplicationUser> viewprofile(String userId) {
        Optional<ApplicationUser> user = repo.findById(userId);
        return user;
    }

}

