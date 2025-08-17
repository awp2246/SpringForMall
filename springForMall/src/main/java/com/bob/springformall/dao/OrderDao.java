package com.bob.springformall.dao;

import com.bob.springformall.model.Order;
import com.bob.springformall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItem(Integer orderId, List<OrderItem> orderItemList);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemById(Integer orderId);
}
