package com.kuka.service;

import com.kuka.dto.OrderDto;
import com.kuka.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    OrderDto saveOrder(OrderDto order);
    List<OrderDto> getAllOrderByUserId(int userId);

    OrderDto getOrderById(int orderId);

}
