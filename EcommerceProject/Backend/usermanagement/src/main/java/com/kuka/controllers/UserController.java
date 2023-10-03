package com.kuka.controllers;

import com.kuka.service.IUserService;
import com.kuka.dtos.AddUser;
import com.kuka.dtos.AppUserDetails;
import com.kuka.dtos.LoginRequest;
import com.kuka.exceptions.AuthenticationException;
import com.kuka.exceptions.DuplicateDataException;
import com.kuka.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    /**
     * Handles a POST request for user login.
     *
     * @param loginRequest The login request containing user credentials.
     * @return ResponseEntity containing the generated token on successful authentication (HTTP status 200),
     * or an error message on authentication failure (HTTP status 500).
     */

    @PostMapping("/user/login")
    public ResponseEntity<?> createToken(@RequestBody @Valid LoginRequest loginRequest) {
        try {
            String token = service.generateTokenAfterCredentialsCheck(loginRequest);
            AppUserDetails appUserDetails =service.findUserDetailsByUsername(loginRequest.getUsername());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("userDetails", appUserDetails);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        }
    }

    /**
     * Handles a POST request to register an user.
     *
     * @param addUser
     * @return ResponseEntity containing the registered user details on success (HTTP status 201),
     * or an error message on failure (HTTP status 500).
     */

    @PostMapping("/user/registeration")
    public ResponseEntity<?> registerUser(@RequestBody @Valid AddUser addUser) {
        try {
            AppUserDetails registeredUser = service.registerUser(addUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (DuplicateDataException e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        }
    }

    /**
     * Handles a POST request to register an admin user.
     *
     * @param addUser The user information to be registered, provided as a JSON request body.
     * @return ResponseEntity containing either the registered admin details or an error message.
     */

    @PostMapping("/a/registeradmin")
    public ResponseEntity<?> registerAdmin(@RequestBody @Valid AddUser addUser) {
        try {
            AppUserDetails registeredAdmin = service.registerAdmin(addUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredAdmin);
        } catch (DuplicateDataException e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        }
    }

    /**
     * Handles a GET request to retrieve user details by username.
     *
     * @param username The username of the user to retrieve.
     * @return ResponseEntity containing either the user details or an error message.
     */

    @GetMapping("/a/user/retrieve/{username}")
    public ResponseEntity<?> getUserDetailsByUsername(@PathVariable @NotBlank String username) {
        try {
            AppUserDetails userDetails = service.findUserDetailsByUsername(username);
            return ResponseEntity.ok(userDetails);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        }

    }

    /**
     * Handles a PUT request to update a user's details.
     *
     * @param userDetails The user details to be updated, provided as a JSON request body.
     * @return ResponseEntity containing either the updated user details or an error message.
     * @throws Exception If an unexpected error occurs during the update process.
     */
    @PutMapping("a/user/updateuser")
    public ResponseEntity<?> updateUser(@RequestBody AppUserDetails userDetails) throws Exception {
        if (userDetails.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            return ResponseEntity.ok(service.updateUser(userDetails));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        }

    }

    /**
     * Handles a DELETE request to delete a user by their ID.
     *
     * @param id The ID of the user to be deleted, provided as a path variable.
     * @return ResponseEntity containing either the deleted user's ID or an error message.
     */
    @DeleteMapping("a/user/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            service.deleteUser(id);
            return ResponseEntity.ok(id);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.valueOf(500)).body(e.getMessage());
        }
    }
}
