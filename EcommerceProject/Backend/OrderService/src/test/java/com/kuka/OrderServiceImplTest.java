package com.kuka;

import com.kuka.dto.OrderDto;
import com.kuka.entity.Order;
import com.kuka.exception.ResourceNotFoundException;
import com.kuka.repository.OrderRepository;
import com.kuka.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveOrder() {
        OrderDto orderDto = new OrderDto(); // Create a sample OrderDto
        Order order = new Order(); // Create a sample Order
        when(modelMapper.map(orderDto, Order.class)).thenReturn(order);
        when(orderRepository.save(order)).thenReturn(order);
        when(modelMapper.map(order, OrderDto.class)).thenReturn(orderDto);

        OrderDto savedOrderDto = orderService.saveOrder(orderDto);

        assert savedOrderDto != null;
    }

    /*@Test
    public void testGetAllOrderByUserId() {
        int userId = 1;
        List<Order> orderList = new ArrayList<>();
        when(orderRepository.findAllByUserId(userId)).thenReturn(Optional.of(orderList));
        when(modelMapper.map(any(), eq(OrderDto.class))).thenReturn(new OrderDto());

        List<OrderDto> orders = orderService.getAllOrderByUserId(userId);

        assert !orders.isEmpty();
    }*/

    @Test
    public void testGetOrderById() {
        int orderId = 1;
        Order order = new Order(); // Create a sample Order
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
        when(modelMapper.map(order, OrderDto.class)).thenReturn(new OrderDto());

        OrderDto orderDto = orderService.getOrderById(orderId);

        assert orderDto != null;
    }

    @Test
    public void testGetOrderByIdNotFound() {
        int orderId = 1;
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        try {
            orderService.getOrderById(orderId);
        } catch (ResourceNotFoundException e) {
            assert e.getMessage().contains("Order not found with ID: " + orderId);
        }
    }
}
