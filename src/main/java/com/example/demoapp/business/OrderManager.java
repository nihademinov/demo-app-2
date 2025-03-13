package com.example.demoapp.business;

import com.example.demoapp.api.model.request.OrderCreateDto;
import com.example.demoapp.api.model.request.OrderUpdateDto;
import com.example.demoapp.api.model.response.OrderResponseDto;
import com.example.demoapp.domain.Order;
import com.example.demoapp.exception.NotFoundException;
import com.example.demoapp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static com.example.demoapp.api.model.constrants.ValidationMessages.ORDER_NOT_ACTIVE_FOUND;
import static com.example.demoapp.api.model.constrants.ValidationMessages.ORDER_NOT_FOUND;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderManager {

    private final OrderRepository orderRepository;
    private final UserManager userManager;
    private final VehicleManager vehicleManager;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<OrderResponseDto> getAllOrders() {
        List<Order> allOrders = orderRepository.findAllByActiveTrue();

        if (allOrders.isEmpty()) {
            throw new NotFoundException(ORDER_NOT_ACTIVE_FOUND);
        }

        return allOrders.stream()
                .map(order -> modelMapper.map(order, OrderResponseDto.class))
                .toList();
    }

    public void createOrder(OrderCreateDto request) {

        orderRepository.save(Order.builder()
                .user(userManager.getUserById(request.getUserId()))
                .vehicle(vehicleManager.getVehicleById(request.getVehicleId()))
                .receiveDate(request.getReceiveDate())
                .deliveryDate(request.getDeliveryDate())
                .active(true)
                .build());


    }

    public void deleteOrder(UUID orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException(ORDER_NOT_FOUND));
        order.setActive(false);
        orderRepository.save(order);
    }

    public OrderResponseDto updateOrder(OrderUpdateDto request, UUID orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException(ORDER_NOT_FOUND));

        order.setUser(userManager.getUserById(request.getUserId()));
        order.setVehicle(vehicleManager.getVehicleById(request.getVehicleId()));
        order.setReceiveDate(request.getReceiveDate());
        order.setDeliveryDate(request.getDeliveryDate());
        orderRepository.save(order);
        return modelMapper.map(order, OrderResponseDto.class);


    }
}
