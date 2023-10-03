package com.kuka.service;

import com.kuka.dtos.AddUser;
import com.kuka.dtos.AppUserDetails;
import com.kuka.dtos.LoginRequest;
import com.kuka.dtos.UserDetailsImpl;
import com.kuka.util.TokenUtil;
import com.kuka.dao.UserRepository;
import com.kuka.entities.User;
import com.kuka.exceptions.AuthenticationException;
import com.kuka.exceptions.DuplicateDataException;
import com.kuka.exceptions.UserNotFoundException;
import com.kuka.util.UserUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.kuka.exceptions.UserExceptionUtils.*;

/**
 * Service class responsible for managing user-related operations.
 */

@Service
public class UserServiceImpl implements UserDetailsService, IUserService, UserDetailsPasswordService {

    private UserRepository userRepo;

    private TokenUtil tokenUtil;

    private UserUtil userUtil;

    @Autowired
    private ApplicationContext context;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public UserServiceImpl(UserRepository repository, TokenUtil tokenUtil, UserUtil userUtil) {
        this.userRepo = repository;
        this.tokenUtil = tokenUtil;
        this.userUtil = userUtil;
    }

    public PasswordEncoder getPasswordEncoder() {
        if (passwordEncoder != null) {
            return passwordEncoder;
        }
        return context.getBean(PasswordEncoder.class);
    }

    public AuthenticationManager getAuthenticationManager() {
        if (authenticationManager != null) {
            return authenticationManager;
        }
        return context.getBean(AuthenticationManager.class);
    }

    /**
     * Loads user details by username.
     *
     * @param username The username of the user to load.
     * @return UserDetails representing the user's details.
     * @throws UsernameNotFoundException if the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        return toUserDetails(user);
    }

    /**
     * Retrieves user details by username.
     *
     * @param username The username of the user to retrieve.
     * @return AppUserDetails representing the user's details.
     */

    @Override
    public AppUserDetails findUserDetailsByUsername(String username) {
        User user = findByUsername(username);
        return userUtil.toUserDetails(user);
    }

    /**
     * Finds a user by their username.
     *
     * @param username The username of the user to find.
     * @return The User object if found.
     * @throws UsernameNotFoundException if the user is not found.
     */

    public User findByUsername(String username) {
        Optional<User> optional = userRepo.findUserByUsername(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException(USER_NOT_FOUND);
        }
        return optional.get();
    }

    /**
     * Converts a User object to UserDetails.
     *
     * @param user The User object to convert.
     * @return UserDetails representing the user's details.
     */

    public UserDetails toUserDetails(User user) {
        UserDetailsImpl details = new UserDetailsImpl();
        details.setUsername(user.getUsername());
        details.setPassword(user.getPassword());
        String roles = user.getRoles();
        Collection<String> roleList = Arrays.asList(roles);
        List<SimpleGrantedAuthority> authorities = toAuthorities(roleList);
        details.setAuthorities(authorities);
        return details;
    }

    /**
     * Converts a collection of roles to SimpleGrantedAuthorities.
     *
     * @param roles The roles to convert.
     * @return List of SimpleGrantedAuthorities.
     */

    public List<SimpleGrantedAuthority> toAuthorities(Collection<String> roles) {
        List<SimpleGrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase())).collect(Collectors.toList());
        return authorities;
    }

    /**
     * Generates an authentication token after validating user credentials.
     *
     * @param requestData The LoginRequest object containing user login credentials.
     * @return A JWT (JSON Web Token) representing the user's authenticated session.
     * @throws AuthenticationException If user authentication fails.
     */

    @Override
    public String generateTokenAfterCredentialsCheck(LoginRequest requestData) {
        String encodedPassword = getPasswordEncoder().encode(requestData.getPassword());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestData.getUsername(), requestData.getPassword());
        System.out.println("****authenticated to be done");
        Authentication authenticate = getAuthenticationManager().authenticate(token);
        if (authenticate != null && authenticate.isAuthenticated()) {
            System.out.println("****authentication done");
            String jwtToken = tokenUtil.encode(requestData.getUsername());
            return jwtToken;
        } else {
            throw new AuthenticationException(USER_NOT_AUTHENTICATED);
        }
    }

    /**
     * Updates user details based on the provided AppUserDetails object.
     *
     * @param userDetails The AppUserDetails object containing the updated user details.
     * @return AppUserDetails representing the updated user after the changes.
     * @throws UserNotFoundException If the user with the specified ID is not found.
     * @throws Exception             If an unexpected error occurs during the update process.
     */

    public AppUserDetails updateUser(AppUserDetails userDetails) throws Exception {
        Optional<User> userOptional = userRepo.findById(userDetails.getId());
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        User user = userOptional.get();
        if (!StringUtils.isEmpty(userDetails.getUsername())) {
            user.setUsername(userDetails.getUsername());
        }
        if (!StringUtils.isEmpty(userDetails.getEmail())) {
            user.setEmail(userDetails.getEmail());
        }
        user = userRepo.saveAndFlush(user);
        BeanUtils.copyProperties(user, userDetails);
        return userDetails;
    }

    /**
     * Deletes a user based on their unique identifier (ID).
     *
     * @param id The unique identifier (ID) of the user to be deleted.
     * @throws UserNotFoundException If the user with the specified ID is not found.
     */

    @Override
    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        userRepo.deleteById(id);
    }

    /**
     * Updates the password for a user identified by their username.
     *
     * @param user        The UserDetails object representing the user whose password is to be updated.
     * @param newPassword The new password to set for the user.
     * @return UserDetails representing the updated user with the new password.
     */

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        User found = findByUsername(user.getUsername());
        found.setPassword(newPassword);
        found = userRepo.save(found);
        return toUserDetails(found);
    }

    /**
     * Registers a new user with the "USER" role.
     *
     * @param requestData The user registration data.
     * @return AppUserDetails representing the registered user's details.
     */

    @Override
    @Transactional
    public AppUserDetails registerUser(AddUser requestData) {

        return registerUser(requestData, "USER");
    }

    /**
     * Registers a new admin user with the "ADMIN" role.
     *
     * @param requestData The admin user registration data.
     * @return AppUserDetails representing the registered admin user's details.
     */

    @Override
    @Transactional
    public AppUserDetails registerAdmin(AddUser requestData) {

        return registerUser(requestData, "ADMIN");
    }

    public AppUserDetails registerUser(AddUser addUser, String role) {
        if (userRepo.findUserByUsername(addUser.getUsername()).isPresent()) {

            throw new DuplicateDataException(USER_ALREADY_REGISTERED);
        }
        User user = new User();
        user.setUsername(addUser.getUsername());
        String encodedPassword = getPasswordEncoder().encode(addUser.getPassword());
        user.setPassword(encodedPassword);
        user.setEmail(addUser.getEmail());
        user.setRoles(role);
        user.setCreatedAt(LocalDateTime.now());
        user = userRepo.save(user);
        return userUtil.toUserDetails(user);

    }

}
