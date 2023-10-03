package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.UserRecord;



public interface UserRepository extends CrudRepository<UserRecord,String> {



}
