package com.maveric.api.Test.serviceimpl;


import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



	import static org.junit.Assert.assertEquals;
	import static org.mockito.Mockito.*;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.junit.Before;
//	import org.junit.Test;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.MockitoAnnotations;

	import com.maveric.api.Model.User;
	import com.maveric.api.Repository.Userrepo;
	import com.maveric.api.service.Userservice;
	import com.maveric.api.serviceimpl.Userserviceimpl;

	public class Serviceimpl { 

	    @Mock
	    private Userrepo userrepo;

	    @InjectMocks
	    private Userserviceimpl userService;
	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testCreateUser() {
	        User user = new User();
	        user.setFirstName("John");
	        user.setLastName("Doe");
	        user.setEmail("john.doe@example.com");

	        when(userrepo.save(user)).thenReturn(user);

	        User createdUser = userService.createUser(user);

	        assertEquals("John", createdUser.getFirstName());
	        assertEquals("Doe", createdUser.getLastName());
	        assertEquals("john.doe@example.com", createdUser.getEmail());

	        verify(userrepo, times(1)).save(user);
	    }

	    @Test
	    public void testGetUserById() {
	        User user = new User();
	        user.setId(1L);
	        user.setFirstName("John");
	        user.setLastName("Doe");
	        user.setEmail("john.doe@example.com");

	        when(userrepo.findById(1L)).thenReturn(Optional.of(user));

	        User foundUser = userService.getUserById(1L);

	        assertEquals("John", foundUser.getFirstName());
	        assertEquals("Doe", foundUser.getLastName());
	        assertEquals("john.doe@example.com", foundUser.getEmail());

	        verify(userrepo, times(1)).findById(1L);
	    }

	    @Test
	    public void testGetAllUsers() {
	        List<User> users = new ArrayList<>();
	        users.add(new User(1L, "John", "Doe", "john.doe@example.com"));
	        users.add(new User(2L, "Jane", "Smith", "jane.smith@example.com"));

	        when(userrepo.findAll()).thenReturn(users);

	        List<User> allUsers = userService.getAllUsers();

	        assertEquals(2, allUsers.size());
	        assertEquals("John", allUsers.get(0).getFirstName());
	        assertEquals("Doe", allUsers.get(0).getLastName());
	        assertEquals("john.doe@example.com", allUsers.get(0).getEmail());
	        assertEquals("Jane", allUsers.get(1).getFirstName());
	        assertEquals("Smith", allUsers.get(1).getLastName());
	        assertEquals("jane.smith@example.com", allUsers.get(1).getEmail());

	        verify(userrepo, times(1)).findAll();
	    }

	    @Test
	    public void testUpdateUser() {
	        User existingUser = new User(1L, "John", "Doe", "john.doe@example.com");

	        when(userrepo.findById(1L)).thenReturn(Optional.of(existingUser));
	        when(userrepo.save(existingUser)).thenReturn(existingUser);

	        User updatedUser = new User();
	        updatedUser.setId(1L);
	        updatedUser.setFirstName("UpdatedJohn");
	        updatedUser.setLastName("UpdatedDoe");
	        updatedUser.setEmail("updated.john.doe@example.com");

	        User result = userService.updateUser(updatedUser);

	        assertEquals("UpdatedJohn", result.getFirstName());
	        assertEquals("UpdatedDoe", result.getLastName());
	        assertEquals("updated.john.doe@example.com", result.getEmail());

	        verify(userrepo, times(1)).findById(1L);
	        verify(userrepo, times(1)).save(existingUser);
	    }

	    @Test
	    public void testDeleteUser() {
	        Long userId = 1L;

	        userService.deleteUser(userId);

	        verify(userrepo, times(1)).deleteById(userId);
	    }
	}


