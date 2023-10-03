package com.kuka.repository;

import com.kuka.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Optional<List<Order>> findAllByUserId(int userId);
}
