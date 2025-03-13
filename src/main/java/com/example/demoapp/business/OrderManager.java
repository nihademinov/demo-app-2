package com.example.demoapp.business;

import com.example.demoapp.api.model.response.OrderResponseDto;
import com.example.demoapp.api.model.response.VehicleResponseDto;
import com.example.demoapp.domain.Order;
import com.example.demoapp.exception.NotFoundException;
import com.example.demoapp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demoapp.api.model.constrants.ValidationMessages.ORDER_NOT_ACTIVE_FOUND;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderManager {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper =  new ModelMapper();

    public List<OrderResponseDto> getAllOrders(){
        List<Order> allOrders = orderRepository.findAllByActiveTrue();

        if (allOrders.isEmpty()) {
            throw new NotFoundException(ORDER_NOT_ACTIVE_FOUND);
        }

        return allOrders.stream()
                .map(order -> modelMapper.map(order, OrderResponseDto.class))
                .toList();
    }
}
