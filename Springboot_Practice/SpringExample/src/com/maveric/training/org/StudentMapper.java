package com.maveric.training.org;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class StudentMapper implements RowMapper<Student> {
		   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Student student = new Student();
		      student.setSid(rs.getInt("Sid"));
		      student.setSname(rs.getString("Sname"));
		      student.setAge(rs.getInt("Age"));
		      return student;
		   }
}
