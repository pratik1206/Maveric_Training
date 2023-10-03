package com.maveric.api.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maveric.api.model.Student;

import jakarta.persistence.EntityManager;


@Repository
public class Studentdaoimpl implements Studentdao {
    @Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> query = currentSession.createQuery("from Student",Student.class);
		List<Student> list = query.getResultList();
		return list;
	}

	@Override
	public Student get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student studentobj = currentSession.get(Student.class, id);
		return studentobj;
	}
	
	@Override
	public void save(Student student) {
		Session currentSession = entityManager.unwrap(Session.class);
		   currentSession.persist(student);
		}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student studentobj = currentSession.get(Student.class, id);
		currentSession.delete(studentobj);
		
	}

	
}
