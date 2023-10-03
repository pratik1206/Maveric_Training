package com.kuka.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuka.controllers.UserController;
import com.kuka.dtos.AddUser;
import com.kuka.dtos.AppUserDetails;
import com.kuka.dtos.LoginRequest;
import com.kuka.exceptions.AuthenticationException;
import com.kuka.exceptions.DuplicateDataException;
import com.kuka.exceptions.UserNotFoundException;
import com.kuka.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private IUserService userService;

    private MockMvc mockMvc;


        @Before
        public void setup() {

            mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        }

    @Test
    public void registerUserTest() throws Exception {
        AddUser addUser = new AddUser();
        addUser.setUsername("testuser");
        addUser.setPassword("testpassword");
        addUser.setEmail("testuser@gmail.com");

        AppUserDetails appUserDetails = new AppUserDetails(1L, "Sridevi", "USER", "sre@gmail.com");
        when(userService.registerUser(addUser)).thenReturn(appUserDetails);

        ResultActions resultActions = mockMvc.perform(
                post("/users/user/registeration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addUser))
        );
        resultActions
                .andExpect(status().isCreated())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(appUserDetails)));
    }

    @Test
    public void registerUserTestFail() throws Exception {
        AddUser addUser = new AddUser();
        addUser.setUsername("testuser");
        addUser.setPassword("testpassword");
        addUser.setEmail("testuser@gmail.com");

        doThrow(new DuplicateDataException("Duplicate Data")).when(userService).registerUser(addUser);

        ResultActions resultActions = mockMvc.perform(
                post("/users/user/registeration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addUser))
        );

        resultActions.andExpect(status().isInternalServerError());
    }

    @Test
    public void registerUserTestException() throws Exception {
        AddUser addUser = new AddUser();
        addUser.setUsername("testuser");
        addUser.setPassword("testpassword");
        addUser.setEmail("testuser@gmail.com");

        when(userService.registerUser(addUser)).thenThrow(new RuntimeException("Some internal error"));

        ResultActions resultActions = mockMvc.perform(
                post("/users/user/registeration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addUser))
        );

        resultActions.andExpect(status().isInternalServerError());
    }
    @Test
    public void adminUserTest() throws Exception {
        AddUser addUser = new AddUser();
        addUser.setUsername("adminuser");
        addUser.setPassword("testpassword");
        addUser.setEmail("testadmin@gmail.com");

        AppUserDetails appUserDetails = new AppUserDetails(1L, "adminuser", "ADMIN", "testadmin@gmail.com");
        when(userService.registerAdmin(addUser)).thenReturn(appUserDetails);

        ResultActions resultActions = mockMvc.perform(
                post("/users/a/registeradmin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addUser))
        );
        resultActions
                .andExpect(status().isCreated())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(appUserDetails)));
    }
    @Test
    public void registerAdminTestFail() throws Exception {
        AddUser addUser = new AddUser();
        addUser.setUsername("testadmin");
        addUser.setPassword("testpassword");
        addUser.setEmail("testadmin@gmail.com");

        doThrow(new DuplicateDataException("Duplicate Data")).when(userService).registerAdmin(addUser);

        ResultActions resultActions = mockMvc.perform(
                post("/users/a/registeradmin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addUser))
        );

        resultActions.andExpect(status().isInternalServerError());
    }

    @Test
    public void registerAdminTestException() throws Exception {
        AddUser addUser = new AddUser();
        addUser.setUsername("testuser");
        addUser.setPassword("testpassword");
        addUser.setEmail("testuser@gmail.com");

        when(userService.registerAdmin(addUser)).thenThrow(new RuntimeException("Some internal error"));

        ResultActions resultActions = mockMvc.perform(
                post("/users/a/registeradmin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addUser))
        );

        resultActions.andExpect(status().isInternalServerError());
    }


    @Test
    public void createTokenTest() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testuser");
        loginRequest.setPassword("testpassword");

        String token = "testToken";
        AppUserDetails userDetails = new AppUserDetails(); // Create a mock user details object
        when(userService.generateTokenAfterCredentialsCheck(loginRequest)).thenReturn(token);
        when(userService.findUserDetailsByUsername(loginRequest.getUsername())).thenReturn(userDetails);

        ResultActions resultActions = mockMvc.perform(
                post("/users/user/login") // Adjust the URL to match your controller mapping
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(loginRequest))
        );

        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value(token)) // Check the "token" field
                .andExpect(jsonPath("$.userDetails").value(userDetails)); // Check the "userDetails" field
    }

    @Test
    public void createTokenTestAuthenticationException() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testuser");
        loginRequest.setPassword("testpassword");

        doThrow(new AuthenticationException("Authentication failed")).when(userService).generateTokenAfterCredentialsCheck(loginRequest);

        ResultActions resultActions = mockMvc.perform(
                post("/users/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(loginRequest))
        );

        resultActions.andExpect(status().isInternalServerError());
    }

    @Test
    public void createTokenTestException() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testuser");
        loginRequest.setPassword("testpassword");

        when(userService.generateTokenAfterCredentialsCheck(loginRequest)).thenThrow(new RuntimeException("Some internal error"));

        ResultActions resultActions = mockMvc.perform(
                post("/users/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(loginRequest))
        );

        resultActions.andExpect(status().isInternalServerError());
    }

    @Test
    public void getUserDetailsByUsernameTest() throws Exception {
        String username = "testuser";
        AppUserDetails userDetails = new AppUserDetails(1L, "Sridevi", "USER", "sre@gmail.com");

        when(userService.findUserDetailsByUsername(username)).thenReturn(userDetails);

        ResultActions resultActions = mockMvc.perform(
                get("/users/a/user/retrieve/{username}", username)
        );

        resultActions
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(userDetails)));
    }

    @Test
    public void getUserDetailsByUsernameTestUserNotFoundException() throws Exception {
        String username = "nonexistentuser";

        doThrow(new UserNotFoundException("User not found")).when(userService).findUserDetailsByUsername(username);

        ResultActions resultActions = mockMvc.perform(
                get("/users/a/user/retrieve/{username}", username)
        );

        resultActions.andExpect(status().isInternalServerError());
    }

    @Test
    public void getUserDetailsByUsernameTestException() throws Exception {
        String username = "testuser";

        when(userService.findUserDetailsByUsername(username)).thenThrow(new RuntimeException("Some internal error"));

        ResultActions resultActions = mockMvc.perform(
                get("/users/a/user/retrieve/{username}", username)
        );

        resultActions.andExpect(status().isInternalServerError());
    }
    @Test
    public void updateUserTest() throws Exception {
        AppUserDetails userDetails = new AppUserDetails(1L, "Sridevi","sre@gmail.com");

        when(userService.updateUser(userDetails)).thenReturn(userDetails);

        ResultActions resultActions = mockMvc.perform(
                put("/users/a/user/updateuser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDetails))
        );

        resultActions
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(userDetails)));
    }
    @Test
    public void updateUserTestUserNotFoundException() throws Exception {
        AppUserDetails userDetails = new AppUserDetails(1L, "Sridevi","sre@gmail.com");

        when(userService.updateUser(userDetails)).thenThrow(new UserNotFoundException("User not found"));

        ResultActions resultActions = mockMvc.perform(
                put("/users/a/user/updateuser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDetails))
        );

        resultActions.andExpect(status().isInternalServerError());
    }
    @Test
    public void updateUserTestException() throws Exception {
        AppUserDetails userDetails = new AppUserDetails(1L, "Sridevi","sre@gmail.com");

        when(userService.updateUser(userDetails)).thenThrow(new RuntimeException("Some internal error"));

        ResultActions resultActions = mockMvc.perform(
                put("/users/a/user/updateuser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDetails))
        );

        resultActions.andExpect(status().isInternalServerError());
    }
    @Test
    public void deleteUserTest() throws Exception {
        Long userId = 1L;

        doNothing().when(userService).deleteUser(userId);

        ResultActions resultActions = mockMvc.perform(
                delete("/users/a/user/deleteuser/{id}", userId)
        );

        resultActions.andExpect(status().isOk());
    }
    @Test
    public void deleteUserNotFoundTest() throws Exception {
        Long userId = 1L;

        doThrow(new UserNotFoundException("User not found")).when(userService).deleteUser(userId);

        ResultActions resultActions = mockMvc.perform(
                delete("/users/a/user/deleteuser/{id}", userId)
        );

        resultActions.andExpect(status().isInternalServerError());
    }


}
