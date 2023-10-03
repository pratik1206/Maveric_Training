package com.maveric.training.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maveric.training.Model.Post;

public interface PostRepository  extends JpaRepository<Post, Long>{

}
