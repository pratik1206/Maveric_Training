package com.example.demo.ServiceTest;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.Model.UserRecord;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        List<UserRecord> userRecords = new ArrayList<>();
        userRecords.add(new UserRecord(1, "User1","user@gmail.com"));
        userRecords.add(new UserRecord(2, "User1","user@gmail.com"));

        when(userRepository.findAll()).thenReturn(userRecords);

        List<UserRecord> result = userService.getAllUsers();

        // Assertions and verifications
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testAddUser() {
        UserRecord userRecord = new UserRecord(1, "User1","user@gmail.com");

        userService.addUser(userRecord);

        // Verification
        verify(userRepository, times(1)).save(userRecord);
    }

    @Test
    void testDeleteUser() {
        String userId = "1";

        userService.deleteUser(userId);

        // Verification
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testGetAllUsersById() {
        String userId = "1";
        userService.getAllUsersBYId(userId);
        
        UserRecord userRecord = new UserRecord(1 , "User1","user@gmail.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(userRecord));

        Optional<UserRecord> result = userService.getAllUsersBYId(userId);

        // Assertions and verifications
        assertTrue(result.isPresent());
        assertEquals(userId, result.get().getId());
        verify(userRepository, times(1)).findById(userId);
    }
    
    @Test
    void testaddUser() {
    	UserRecord userrecord = new UserRecord(1,"pratik","pratik@gmail.com");
    	
    	userService.addUsers(userrecord);
    	
//    	assertEquals(userRepository, userrecord);
    	verify(userRepository,times(1)).save(userrecord);
    }
}

