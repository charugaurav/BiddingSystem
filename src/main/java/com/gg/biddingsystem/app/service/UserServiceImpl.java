package com.gg.biddingsystem.app.service;

import com.gg.biddingsystem.app.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import com.gg.biddingsystem.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<AppUser> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        return userRepository.save(appUser);
    }
}

