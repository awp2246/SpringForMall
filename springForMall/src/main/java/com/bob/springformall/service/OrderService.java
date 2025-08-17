package com.bob.springformall.service;

import com.bob.springformall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer user, CreateOrderRequest createOrderRequest);
}
