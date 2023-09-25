package com.derp.scottSmallProj.controller;

import com.derp.scottSmallProj.service.appUserService;
import com.derp.scottSmallProj.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AppUserController {

    private com.derp.scottSmallProj.service.appUserService appUserService;

    @Autowired
    public AppUserController(final appUserService appUserService) {
        this.appUserService = appUserService;
    }

    // save users
    @PostMapping("/appUsers")
    public AppUser saveAppUser (
        @RequestBody AppUser appUser) {
        System.out.println("Called save user request with the following: " + appUser);
        try {
            return appUserService.saveAppUser(appUser);
    } catch(Exception e) {
            System.out.println("Something went wrong.");
        }
        return appUserService.saveAppUser(appUser);
    }

    // get all users users
    @GetMapping("/appUsers")
    public List<AppUser> fetchAppUsersList() {
        List<AppUser> appUsers = appUserService.fetchAppUserList();
        System.out.println("Get all user(s) request called" + appUsers);
        return appUsers;
    }

    // update user
    @PutMapping("/appUsers/update/{id}")
    public AppUser updateAppUser(@RequestBody AppUser appUser, @PathVariable("id") UUID appUserId)
    {
        System.out.println("Update user request for userId: " + appUserId);
        System.out.println("Update user request with request body: " + appUser);
        return appUserService.updateAppUser (appUser, appUserId);
    }

    // Delete user
    @DeleteMapping("/appUsers/delete/{id}")
    public String deleteAppUserById(@PathVariable("id") UUID appUserId)
    {
        System.out.println("Delete user request for userId: " + appUserId);
        appUserService.deleteAppUserById(appUserId);
        return "Deleted Successfully";
    }
}
