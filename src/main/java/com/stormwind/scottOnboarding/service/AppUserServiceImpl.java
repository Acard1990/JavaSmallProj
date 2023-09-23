package com.stormwind.scottOnboarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;
import java.util.Objects;

import com.stormwind.scottOnboarding.repository.AppUserRepository;
import com.stormwind.scottOnboarding.entity.AppUser;
import org.springframework.stereotype.Component;


@Component
public class AppUserServiceImpl implements appUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    // save operation
    @Override
    public AppUser saveAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    // read operation
    @Override
    public List<AppUser> fetchAppUserList() {
        return (List<AppUser>) appUserRepository.findAll();
    }

    // update operation
    @Override
    public AppUser updateAppUser(AppUser appUser, UUID appUserId) {
        // get by Id
        AppUser appUserDB = appUserRepository.findById(appUserId).get();

        // update first name
        if (Objects.nonNull(appUser.getFirstName()) && !"".equalsIgnoreCase(appUser.getFirstName())) {
            appUserDB.setFirstName(appUser.getFirstName());
        }

        // update last name
        if (Objects.nonNull(appUser.getLastName()) && !"".equalsIgnoreCase(appUser.getLastName())) {
            appUserDB.setLastName(appUser.getLastName());
        }

        // update email
        if (Objects.nonNull(appUser.getEmail()) && !"".equalsIgnoreCase(appUser.getEmail())) {
            appUserDB.setEmail(appUser.getEmail());
        }

        return appUserRepository.save(appUserDB);
    }

    // delete operation
    @Override
    public void deleteAppUserById(UUID appUserId) {
        appUserRepository.deleteById(appUserId);
    }
}
