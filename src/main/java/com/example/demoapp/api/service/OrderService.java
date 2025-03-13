package com.example.demoapp.api.service;

import com.example.demoapp.api.model.response.OrderResponseDto;
import com.example.demoapp.business.OrderManager;
import com.example.demoapp.business.validator.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderManager orderManager;
    private final OrderValidator orderValidator;

    public List<OrderResponseDto> getAllOrders() {
        return orderManager.getAllOrders();
    }

}
