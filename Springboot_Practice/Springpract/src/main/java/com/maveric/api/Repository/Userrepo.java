package com.maveric.api.Repository;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	 import com.maveric.api.Model.User;

	@Repository
	public interface Userrepo extends JpaRepository<User,Long> {

	}

