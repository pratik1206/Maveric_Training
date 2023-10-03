package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.UserRecord;
import com.example.demo.Model.Response;
import com.example.demo.Service.UserService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController 
public class UserController {
	@Autowired    
	private UserService userService;     
	@RequestMapping(value="/get", method=RequestMethod.GET)    
	public List<UserRecord> getAllUser()  
	{    
		return userService.getAllUsers();    
	} 
	
	
	@RequestMapping(value="/add-user", method=RequestMethod.POST)    
	public Response addUser(@RequestBody UserRecord userRecord)  
	{    
		Response response = new Response();
    	response.setMessage("Data Sussesfully Submited");
    	response.setError("no Error");
    	response.setStatus("200");
    	response.setUserRecord(userRecord);
   		userService.addUser(userRecord); 
   		return response;
	} 
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)    
	public void addUsers(@RequestBody UserRecord userRecord)  
	{    
		userService.addUser(userRecord);    
	}
	
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	@Operation(
			description="Get All Users By Id",
			summary="checks if id u entering is correct",
			responses= {
			@ApiResponse(
			description = "Valid User",
			responseCode = "201"
			),
			@ApiResponse(
			description = "Unauthorised User",
			responseCode = "401"
			)
			})
	public Optional<UserRecord>  getAllUsersBYID(@PathVariable String id) {
		return userService.getAllUsersBYId(id);
	}
	
}
