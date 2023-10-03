package com.maveric.api.service;


import java.util.List;
	
import com.maveric.api.Model.User; 

	public interface Userservice {
	    User createUser(User user);
        User getUserById(Long userId);
	    List<User> getAllUsers();
	    User updateUser(User user);
	    void deleteUser(Long userId);
   }

