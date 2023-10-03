package com.kuka.controller;

import com.kuka.dto.OrderDto;
import com.kuka.entity.Order;
import com.kuka.service.impl.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/save")
    public ResponseEntity saveOrder(@RequestBody OrderDto orderDto){
        logger.debug("saveOrder(@RequestBody OrderDto orderDto) of OrderController is called");
        OrderDto savedOrder = orderService.saveOrder(orderDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/retrieve/orders/{userId}")
    public ResponseEntity<List<OrderDto>> getAllOrder(@PathVariable int userId){
        logger.debug("getAllOrder(@PathVariable int userId) of OrderController is called");
        List<OrderDto> orders= orderService.getAllOrderByUserId(userId);
        return new ResponseEntity<List<OrderDto>>(orders, HttpStatus.OK);
    }

    @GetMapping("/retrieve/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable int orderId){
        logger.debug("getOrderById(@PathVariable int orderId) of OrderController is called");
        OrderDto order= orderService.getOrderById(orderId);
        return new ResponseEntity<OrderDto>(order, HttpStatus.OK);
    }
}
