package com.example.demo.SpringController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller 
public class UserController {
	   
	@Autowired
	JdbcTemplate jdbc;
	
	class StudentMapper implements RowMapper < User > {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        	
        	System.out.println("mapRow is called");
        	User std = new User();
            
            std.setName(rs.getString("name"));
            std.setEmail(rs.getString("email"));
            
            return std;
        }
    }
	
	@RequestMapping("/User")
	public List < User > findAll(Model model) {
		List<User> userdata  = jdbc.query("select * from user", new StudentMapper());
	    model.addAttribute("User",userdata);
		return userdata;
	}
	  
	
//	@RequestMapping(value="/save", method=RequestMethod.POST)    
//	public ModelAndView save(@ModelAttribute User user)  
//	{    
//	ModelAndView modelAndView = new ModelAndView();    
//	modelAndView.setViewName("user-data");        
//	modelAndView.addObject("user", user);      
//	return modelAndView;    
//	}
}
