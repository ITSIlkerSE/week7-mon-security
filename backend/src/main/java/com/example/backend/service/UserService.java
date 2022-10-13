package com.example.backend.service;

import com.example.backend.model.AppUser;
import com.example.backend.model.CreateUserDto;
import com.example.backend.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {


    private AppUserRepository userRepo;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(PasswordEncoder passwordEncoder, AppUserRepository userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }


    public String register(CreateUserDto createUserDto) {

        String hashPassword = passwordEncoder.encode(createUserDto.getPassword());

        AppUser appUser = new AppUser();
        appUser.setUsername(createUserDto.getUsername());
        appUser.setPasswordHash(hashPassword);
        appUser.setRoles(List.of("USER"));

        return userRepo.save(appUser).getUsername();
    }

}
