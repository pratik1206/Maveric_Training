package com.kuka;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuka.controller.OrderController;
import com.kuka.dto.OrderDto;
import com.kuka.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderServiceImpl orderService;

    @Mock
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderController = new OrderController(orderService);
    }

    @Test
    public void testSaveOrder() {
        OrderDto orderDto = new OrderDto(); // Create a sample OrderDto
        when(orderService.saveOrder(orderDto)).thenReturn(orderDto);

        ResponseEntity responseEntity = orderController.saveOrder(orderDto);

        verify(orderService, times(1)).saveOrder(orderDto);
        assert responseEntity.getStatusCode() == HttpStatus.CREATED;
    }

    @Test
    public void testGetAllOrder() {
        int userId = 1;
        List<OrderDto> orderList = new ArrayList<>();
        when(orderService.getAllOrderByUserId(userId)).thenReturn(orderList);

        ResponseEntity<List<OrderDto>> responseEntity = orderController.getAllOrder(userId);

        verify(orderService, times(1)).getAllOrderByUserId(userId);
        assert responseEntity.getStatusCode() == HttpStatus.OK;
    }

    @Test
    public void testGetOrderById() {
        int orderId = 1;
        OrderDto orderDto = new OrderDto(); // Create a sample OrderDto
        when(orderService.getOrderById(orderId)).thenReturn(orderDto);

        ResponseEntity<OrderDto> responseEntity = orderController.getOrderById(orderId);

        verify(orderService, times(1)).getOrderById(orderId);
        assert responseEntity.getStatusCode() == HttpStatus.OK;
    }
}
