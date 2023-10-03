package com.kuka.service;

import com.kuka.dtos.AddUser;
import com.kuka.dtos.AppUserDetails;
import com.kuka.dtos.LoginRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
public interface IUserService {
    AppUserDetails registerUser(@Valid AddUser requestData);
    AppUserDetails registerAdmin(@Valid AddUser requestData);

    AppUserDetails findUserDetailsByUsername(@NotBlank String username);

    AppUserDetails updateUser( AppUserDetails username) throws Exception;

    void deleteUser( Long id);

    String generateTokenAfterCredentialsCheck(@Valid LoginRequest loginRequest);
}

