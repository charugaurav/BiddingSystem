package com.gg.biddingsystem.app.service;

import com.gg.biddingsystem.app.models.AppUser;

import java.util.Optional;

public interface UserService {
    Optional<AppUser> getUserById(Long userId);
    AppUser saveUser(AppUser appUser);
}
