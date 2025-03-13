package com.example.demoapp.api.service;

import com.example.demoapp.api.model.request.OrderCreateDto;
import com.example.demoapp.api.model.request.OrderUpdateDto;
import com.example.demoapp.api.model.response.OrderResponseDto;
import com.example.demoapp.business.OrderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderManager orderManager;


    public List<OrderResponseDto> getAllOrders() {
        return orderManager.getAllOrders();
    }

    public void createOrder(OrderCreateDto request) {
        orderManager.createOrder(request);
    }

    public void deleteOrder(UUID orderId) {
        orderManager.deleteOrder(orderId);
    }

    public OrderResponseDto updateOrder(OrderUpdateDto request, UUID orderId) {
       return orderManager.updateOrder(request,orderId);
    }

}
