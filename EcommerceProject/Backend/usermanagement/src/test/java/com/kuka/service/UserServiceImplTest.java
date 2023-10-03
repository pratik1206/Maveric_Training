package com.kuka.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.kuka.dao.UserRepository;
import com.kuka.dtos.AddUser;
import com.kuka.dtos.AppUserDetails;
import com.kuka.dtos.LoginRequest;
import com.kuka.entities.User;
import com.kuka.exceptions.AuthenticationException;
import com.kuka.exceptions.DuplicateDataException;
import com.kuka.exceptions.UserNotFoundException;
import com.kuka.service.UserServiceImpl;
import com.kuka.util.TokenUtil;
import com.kuka.util.UserUtil;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {UserServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private TokenUtil tokenUtil;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @MockBean
    private UserUtil userUtil;

    @MockBean
    AuthenticationManager authenticationManager;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    public void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("testuser@example.org");
        user.setId(1L);
        user.setPassword("testpassword");
        user.setRoles("USER");
        user.setUsername("testuser");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsername(Mockito.<String>any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = userServiceImpl.loadUserByUsername("testuser");
        Collection<? extends GrantedAuthority> authorities = actualLoadUserByUsernameResult.getAuthorities();
        assertEquals(1, authorities.size());
        assertEquals("testpassword", actualLoadUserByUsernameResult.getPassword());
        assertEquals("testuser", actualLoadUserByUsernameResult.getUsername());
        assertEquals("ROLE_USER", ((List<? extends GrantedAuthority>) authorities).get(0).getAuthority());
        verify(userRepository).findUserByUsername(Mockito.<String>any());
    }

    @Test
    public void testLoadUserByUsername2() throws UsernameNotFoundException {
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findUserByUsername(Mockito.<String>any())).thenReturn(emptyResult);
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.loadUserByUsername("testuser"));
        verify(userRepository).findUserByUsername(Mockito.<String>any());
    }


    @Test
    public void testFindUserDetailsByUsername() {
        User user = new User();
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("testuser@example.org");
        user.setId(1L);
        user.setPassword("testpassword");
        user.setRoles("USER");
        user.setUsername("testuser");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsername(Mockito.<String>any())).thenReturn(ofResult);
        AppUserDetails appUserDetails = new AppUserDetails();
        when(userUtil.toUserDetails(Mockito.<User>any())).thenReturn(appUserDetails);
        assertSame(appUserDetails, userServiceImpl.findUserDetailsByUsername("testuser"));
        verify(userRepository).findUserByUsername(Mockito.<String>any());
        verify(userUtil).toUserDetails(Mockito.<User>any());
    }

    @Test
    public void testFindUserDetailsByUsername2() {
        User user = new User();
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("testuser@example.org");
        user.setId(1L);
        user.setPassword("testpassword");
        user.setRoles("USER");
        user.setUsername("testuser");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsername(Mockito.<String>any())).thenReturn(ofResult);
        when(userUtil.toUserDetails(Mockito.<User>any())).thenThrow(new UsernameNotFoundException("User not found"));
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.findUserDetailsByUsername("testuser"));
        verify(userRepository).findUserByUsername(Mockito.<String>any());
        verify(userUtil).toUserDetails(Mockito.<User>any());
    }


    @Test
    public void testFindByUsername() {
        User user = new User();
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("testuser@example.org");
        user.setId(1L);
        user.setPassword("testpassword");
        user.setRoles("USER");
        user.setUsername("testuser");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsername(Mockito.<String>any())).thenReturn(ofResult);
        assertSame(user, userServiceImpl.findByUsername("testuser"));
        verify(userRepository).findUserByUsername(Mockito.<String>any());
    }

    @Test
    public void testFindByUsername3() {
        when(userRepository.findUserByUsername(Mockito.<String>any()))
                .thenThrow(new UsernameNotFoundException("User details not found"));
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.findByUsername("testuser"));
        verify(userRepository).findUserByUsername(Mockito.<String>any());
    }


    @Test
    public void testGenerateTokenAfterCredentialsCheck_Success() {

        String username = "testuser";
        String password = "12345";
        String encodedPassword = "encodedPassword";
        String jwtToken = "jwtToken";
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        Authentication authResult =  new UsernamePasswordAuthenticationToken(username,password,authorities);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authResult);

        when(tokenUtil.encode(username)).thenReturn(jwtToken);

        LoginRequest requestData = new LoginRequest(username, password); // Use the actual password here
        String generatedToken = userServiceImpl.generateTokenAfterCredentialsCheck(requestData);

        Assertions.assertEquals(jwtToken, generatedToken);
        verify(passwordEncoder).encode(password);
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(tokenUtil).encode(username);
    }


   @Test
    public void testGenerateTokenAfterCredentialsCheck_AuthenticationFailure() {

        String username = "testuser";
        String password = "wrongPassword"; // Incorrect password
        String encodedPassword = "encodedPassword";
        String jwtToken = "jwtToken";

        when(passwordEncoder.encode(password)).thenReturn(encodedPassword);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        Authentication authResult = new UsernamePasswordAuthenticationToken(username, password, authorities);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(null);

        LoginRequest requestData = new LoginRequest(username, password);
        assertThrows(AuthenticationException.class, () -> userServiceImpl.generateTokenAfterCredentialsCheck(requestData));

        verify(passwordEncoder).encode(password);
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verifyNoInteractions(tokenUtil);
    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("testuser@example.org");
        user.setId(1L);
        user.setPassword("testpassword");
        user.setRoles("USER");
        user.setUsername("testuser");
        Optional<User> ofResult = Optional.of(user);
        doNothing().when(userRepository).deleteById(Mockito.<Long>any());
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        userServiceImpl.deleteUser(1L);
        verify(userRepository).findById(Mockito.<Long>any());
        verify(userRepository).deleteById(Mockito.<Long>any());
    }


    @Test
    public void testDeleteUser2() {
        User user = new User();
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("testuser@example.org");
        user.setId(1L);
        user.setPassword("testpassword");
        user.setRoles("USER");
        user.setUsername("testuser");
        Optional<User> ofResult = Optional.of(user);
        doThrow(new UsernameNotFoundException("Msg")).when(userRepository).deleteById(Mockito.<Long>any());
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.deleteUser(1L));
        verify(userRepository).findById(Mockito.<Long>any());
        verify(userRepository).deleteById(Mockito.<Long>any());
    }


    @Test
    public void testDeleteUser3() {
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(UserNotFoundException.class, () -> userServiceImpl.deleteUser(1L));
        verify(userRepository).findById(Mockito.<Long>any());
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("testuser@example.org");
        user.setId(1L);
        user.setPassword("testpassword");
        user.setRoles("USER");
        user.setUsername("testuser");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsername(Mockito.<String>any())).thenReturn(ofResult);
        assertThrows(DuplicateDataException.class,
                () -> userServiceImpl.registerUser(new AddUser("testuser", "testpassword", "testuser@example.org")));
        verify(userRepository).findUserByUsername(Mockito.<String>any());
    }

    @Test
    public void testRegisterUser3() {
        when(userRepository.findUserByUsername(Mockito.<String>any())).thenThrow(new UsernameNotFoundException("USER"));
        assertThrows(UsernameNotFoundException.class,
                () -> userServiceImpl.registerUser(new AddUser("testuser", "testpassword", "testuser@example.org")));
        verify(userRepository).findUserByUsername(Mockito.<String>any());
    }


    @Test
    public void testRegisterAdmin() {
        User user = new User();
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("testadmin@example.org");
        user.setId(1L);
        user.setPassword("testpassword");
        user.setRoles("ADMIN");
        user.setUsername("testadmin");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsername(Mockito.<String>any())).thenReturn(ofResult);
        assertThrows(DuplicateDataException.class,
                () -> userServiceImpl.registerAdmin(new AddUser("testadmin", "testpassword", "testadmin@example.org")));
        verify(userRepository).findUserByUsername(Mockito.<String>any());
    }

    @Test
    public void testRegisterAdmin3() {
        when(userRepository.findUserByUsername(Mockito.<String>any())).thenThrow(new UsernameNotFoundException("ADMIN"));
        assertThrows(UsernameNotFoundException.class,
                () -> userServiceImpl.registerAdmin(new AddUser("testadmin", "testpassword", "testadmin@example.org")));
        verify(userRepository).findUserByUsername(Mockito.<String>any());
    }
}

