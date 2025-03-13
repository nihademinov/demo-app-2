package com.example.demoapp.api.controller;

import com.example.demoapp.api.model.response.OrderResponseDto;
import com.example.demoapp.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponseDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping
    public void createOrder(OrderCreateDto request){

    }
}
