package com.derp.scottSmallProj.repository;

import com.derp.scottSmallProj.entity.AppUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

@DataJpaTest
@TestMethodOrder(MethodOrderer.class)
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;


    @Test
    @Order(1)
    void saveUser() {
        UUID userUUID = UUID.fromString("2b95a194-91e2-4a40-b605-d49034311347");
        AppUser appUser = new AppUser();
        appUser.setId(userUUID);
        appUser.setFirstName("Test");
        appUser.setLastName("User");
        appUser.setEmail("Test.user@bc.com");

        appUserRepository.save(appUser);
        Assertions.assertThat(appUser.getId()).isEqualTo(userUUID);
    }

    @Test
    @Order(2)
    void getUserById() {
        UUID userUUID = UUID.fromString("2b95a194-91e2-4a40-b605-d49034311347");
        AppUser appUser = new AppUser(userUUID, "test","user","test.user@email.com");
        Assertions.assertThat(appUser.getId()).isEqualTo(userUUID);
    }


    @Test
    @Order(3)
    void deleteUserById() {
        UUID userUUID = UUID.fromString("2b95a194-91e2-4a40-b605-d49034311347");
        AppUser appUser = new AppUser(userUUID, "test","user","test.user@email.com");
        appUserRepository.delete(appUser);
        // assert
    }
}