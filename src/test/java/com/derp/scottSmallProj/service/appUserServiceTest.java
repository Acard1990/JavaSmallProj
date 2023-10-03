package com.derp.scottSmallProj.service;

import com.derp.scottSmallProj.entity.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class appUserServiceTest {


    @Mock
    private appUserService appUserService;

    @Mock
    AppUser appUser;

    public UUID makeUUID(){
        UUID uuid;
        // return uuid = UUID.randomUUID();
        return null;
    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveAppUser() {
        AppUser user1 = new AppUser(makeUUID(),"test","user","test.user@email.com");
        appUserService.saveAppUser(user1);
        verify(appUserService, times(1)).saveAppUser(user1);
    }

    @Test
    void fetchAppUserList() {
        List<AppUser> newAppUserList = new ArrayList<>();
        AppUser appUser1 = new AppUser(makeUUID(), "One", "Test", "One@bc.com");
        AppUser appUser2 = new AppUser(makeUUID(), "Two", "Test", "Two@bc.com");
        AppUser appUser3 = new AppUser(makeUUID(), "Three", "Test", "Three@bc.com");

        newAppUserList.add(appUser1);
        newAppUserList.add(appUser2);
        newAppUserList.add(appUser3);

        when(appUserService.fetchAppUserList()).thenReturn(newAppUserList);

        //test
        List<AppUser> appUserList = appUserService.fetchAppUserList();

        assertEquals(3, appUserList.size());;
        verify(appUserService, times(1)).fetchAppUserList();
    }

    @Test
    void updateAppUser() {
        UUID userUUID = UUID.fromString("2b95a194-91e2-4a40-b605-d49034311347");
        // create user to update
        AppUser user1 = new AppUser(userUUID, "test","user","test.user@email.com");
        appUserService.saveAppUser(user1);

        // update user that was created previously
        AppUser userUpdated = new AppUser(userUUID,"updatedFirst","user","test.user@email.com");
        appUserService.updateAppUser(userUpdated, userUUID);

        // validation
        verify(appUserService, times(1)).updateAppUser(userUpdated, userUUID);
    }

    @Test
    void deleteAppUserById() {
        UUID userUUID = UUID.fromString("2b95a194-91e2-4a40-b605-d49034311347");
        // create user
        AppUser user1 = new AppUser(userUUID,"test","user","test.user@email.com");
        appUserService.saveAppUser(user1);
        // delete user
        appUserService.deleteAppUserById(userUUID);
        // validation
        verify(appUserService, times(1)).deleteAppUserById(userUUID);
    }
}