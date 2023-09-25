package com.derp.scottSmallProj.service;

import com.derp.scottSmallProj.entity.AppUser;

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
