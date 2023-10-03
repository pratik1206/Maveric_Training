//package com.example.demo.SpringController;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class SpringJdbcController {
//	
//	 @Autowired
//	JdbcTemplate jdbc;
//	
//	@RequestMapping("/insert")
//	public String index() {
//		jdbc.execute("insert into User(email,name) values ('JS@gmail.com','java')");
//		return "Data inserted successfully";
//	}
//	
//	@RequestMapping("/insert1")
//	public String index2(@RequestParam ("email") String email, @RequestParam ("name")String name) {
//		jdbc.update("insert into User(email,name) values (?,?)",email,name);
//		return "Data inserted successfully";
//	}
//	@RequestMapping("/list")
//	public List < User > findAll() {
//		return jdbc.query("select * from user", new StudentMapper());
//	}
//	
//	@RequestMapping("/update")
//    public String update() {
//		jdbc.execute("update User set email = 'psjg' where name = 'java@gmail.com'");
//		return "Data update successfully";
//    }
//	
//	@RequestMapping("/delete/{name}")
//    public String delete(@PathVariable String name) {
//		jdbc.update("delete from user where name= ? ", name);
//		return "Data delete successfully";
//    }
//	class StudentMapper implements RowMapper < User > {
//        @Override
//        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//        	
//        	System.out.println("mapRow is called");
//        	User std = new User();
//            
//            std.setName(rs.getString("name"));
//            std.setEmail(rs.getString("email"));
//            
//            return std;
//        }
//    }
//}
