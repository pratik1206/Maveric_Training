package com.maveric.api.controller;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	
	 import com.maveric.api.Model.User;
	 import com.maveric.api.service.Userservice;

	import java.util.List;

	 
	@RestController
	@RequestMapping("/api/users")
	public class Usercontroller  {
	 

	    @Autowired
	    private Userservice userService;

	 

	    // build create User REST API
	    @PostMapping("/post")
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        User savedUser = userService.createUser(user);
	        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	    }

	 

	    // build get user by id REST API
	    // http://localhost:8080/api/users/1
	    @GetMapping("{id}")
	    public ResponseEntity getUserById(@PathVariable("id") Long userId) {
	        try {

	            User user = userService.getUserById(userId);
	            return new ResponseEntity<>(user, HttpStatus.OK);

	        } catch (Exception e) {

	 	            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	        }
	        
	    }
 
	    // Build Get All Users REST API
	    // http://localhost:8080/api/users
	    @GetMapping
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

	 
	    // Build Update User REST API
	    @PutMapping("{id}")
	    // http://localhost:8080/api/users/1
	    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
	        user.setId(userId);
	        User updatedUser = userService.updateUser(user);
	        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	    }
 

	    // Build Delete User REST API
	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
	        userService.deleteUser(userId);
	        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	    }
	}

