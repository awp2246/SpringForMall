package com.bob.springformall.service;

import com.bob.springformall.dto.CreateOrderRequest;
import com.bob.springformall.model.Order;

public interface OrderService {

    Integer createOrder(Integer user, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
