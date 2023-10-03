package com.maveric.training.org;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;





public class StudentJdbcTemplate implements StudentDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public StudentJdbcTemplate() {

	}

	public StudentJdbcTemplate(DataSource dataSource, JdbcTemplate jdbcTemplateObject) {
		super();
		this.dataSource = dataSource;
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String Sname, Integer Age) {
		String SQL = "insert into Students (Sname, Age) values (?, ?)";

		jdbcTemplateObject.update( SQL, Sname, Age);
		System.out.println("Created Record Name = " + Sname + " Age = " + Age);
		return;
	}

	public Student getStudent(Integer Sid) {
		String SQL = "select * from Students where Sid = ?";
		Student student = jdbcTemplateObject.queryForObject(SQL, 
				new Object[]{Sid}, new StudentMapper());
		return student;
	}
	public List<Student> listStudents() {
		String SQL = "select * from Students";
		List <Student> students = jdbcTemplateObject.query(SQL, 
				new StudentMapper());
		return students;
	}

	public void delete(Integer Sid){
		String SQL = "delete from Students where Sid = ?";
		jdbcTemplateObject.update(SQL, Sid);
		System.out.println("Deleted Record with ID = " + Sid );
		return;
	}

	public void update(Integer Sid, Integer Age){
		String SQL = "update Students set Age = ? where Sid = ?";
		jdbcTemplateObject.update(SQL, Age, Sid);
		System.out.println("Updated Record with ID = " + Sid );
		return;
	}

}
