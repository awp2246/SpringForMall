package com.bob.springformall.service.impl;

import com.bob.springformall.dao.OrderDao;
import com.bob.springformall.dao.ProductDao;
import com.bob.springformall.dto.BuyItem;
import com.bob.springformall.dto.CreateOrderRequest;
import com.bob.springformall.model.OrderItem;
import com.bob.springformall.model.Product;
import com.bob.springformall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());
            totalAmount += product.getPrice() * buyItem.getQuantity();

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct_Id(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(product.getPrice() * buyItem.getQuantity());

            orderItemList.add(orderItem);
        }

        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItem(orderId, orderItemList);

        return orderId;
    }
}
