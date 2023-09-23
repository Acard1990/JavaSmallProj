package com.stormwind.scottOnboarding.service;

import com.stormwind.scottOnboarding.entity.AppUser;

import java.util.List;
import java.util.UUID;


public interface appUserService {
    // save
    AppUser saveAppUser(AppUser appUser);

    // get list of users
    List<AppUser> fetchAppUserList();

    // update
    AppUser updateAppUser(AppUser appUser, UUID appUserId);

    // delete
    void deleteAppUserById(UUID appUserId);
}
