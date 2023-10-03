package com.maveric.training.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maveric.training.Model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
