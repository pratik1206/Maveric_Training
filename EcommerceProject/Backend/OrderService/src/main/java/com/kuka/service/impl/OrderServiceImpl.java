package com.kuka.service.impl;

import com.kuka.dto.OrderDto;
import com.kuka.entity.Order;
import com.kuka.exception.ResourceNotFoundException;
import com.kuka.repository.OrderRepository;
import com.kuka.service.IOrderService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        logger.debug("saveOrder(OrderDto orderDto) of OrderServiceImpl is called");
        Order order1 = modelMapper.map(orderDto, Order.class);
        order1.setOrder_date(LocalDateTime.now());
        // Check if the status is blank or null, and set it to the default value if needed
        if (order1.getStatus() == null || order1.getStatus().trim().isEmpty()) {
            order1.setStatus("Pending");
        }
        Order savedOrder = orderRepository.save(order1);
        OrderDto savedOrderDto = modelMapper.map(savedOrder, OrderDto.class);
        return savedOrderDto;
    }

    @Override
    public List<OrderDto> getAllOrderByUserId(int userId) {
        logger.debug("getAllOrderByUserId(int userId) of OrderServiceImpl is called");
        Optional<List<Order>> orders = orderRepository.findAllByUserId(userId);

        if (orders.isPresent()) {
            return orders.get().stream().map((order)->modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
        } else {
            throw new ResourceNotFoundException("No orders found for user with ID: " + userId);
        }
    }

    @Override
    public OrderDto getOrderById(int orderId) {
        logger.debug("getOrderById(int orderId) of OrderServiceImpl is called");
        Optional<Order> order= orderRepository.findById(orderId);
        if (order.isPresent()) {
            return modelMapper.map(order.get(),OrderDto.class);
        } else {
            throw new ResourceNotFoundException("Order not found with ID: " + orderId);
        }
    }
}
