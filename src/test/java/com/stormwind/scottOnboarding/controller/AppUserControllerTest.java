//package com.stormwind.scottOnboarding.controller;
//
//import com.stormwind.scottOnboarding.entity.AppUser;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//class AppUserControllerTest {
//
//    @InjectMocks
//    AppUserController appUserController;
//
//    @Mock
//    AppUser appUser;
//
//    @Test
//    void saveAppUser() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        when(appUserController.saveAppUser(any(AppUser.class))).thenReturn(true);
//
//        AppUser appUser1 = new AppUser(1, "Test", "User", "test.user@bc.com");
//
//        assert(getStatusCodeValue()).isEqualTo(200);
//    }
//
//    @Test
//    void fetchAppUsersList() {
//    }
//
//    @Test
//    void updateAppUser() {
//    }
//
//    @Test
//    void deleteAppUserById() {
//    }
//}