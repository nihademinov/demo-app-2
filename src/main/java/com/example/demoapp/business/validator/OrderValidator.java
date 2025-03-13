package com.example.demoapp.business.validator;


import com.example.demoapp.business.OrderManager;
import com.example.demoapp.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.example.demoapp.api.model.constrants.ValidationMessages.ORDER_NOT_FOUND;

@Component
@RequiredArgsConstructor
public class OrderValidator {
    private final OrderManager orderManager;

//    public void validator(UUID orderId) {
//        boolean exist = orderManager.existsOrder(orderId);
//        if (!exist) {
//            throw new NotFoundException(ORDER_NOT_FOUND);
//        }
//    }


}
