package com.example.demoapp.api.controller;

import com.example.demoapp.api.model.request.OrderCreateDto;
import com.example.demoapp.api.model.request.OrderUpdateDto;
import com.example.demoapp.api.model.response.OrderResponseDto;
import com.example.demoapp.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public void createOrder(@RequestBody OrderCreateDto request) {
        orderService.createOrder(request);
    }

    @PutMapping("/{orderId}")
    public OrderResponseDto updateOrder(@RequestBody OrderUpdateDto request, @PathVariable UUID orderId) {
        return orderService.updateOrder(request, orderId);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable UUID orderId) {
        orderService.deleteOrder(orderId);
    }
}
