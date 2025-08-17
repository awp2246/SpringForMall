package com.bob.springformall.dao.impl;

import com.bob.springformall.dao.OrderDao;
import com.bob.springformall.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createOrder(Integer userId, Integer totalAmount) {
        String sql = "insert into `order`(user_id, total_amount, created_date, last_modified_date)" +
                " values(:userId, :totalAmount, :createdDate, :lastModifiedDate)";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("totalAmount", totalAmount);
        map.put("createdDate", new Date());
        map.put("lastModifiedDate", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int orderId = keyHolder.getKey().intValue();

        return orderId;
    }

    @Override
    public void createOrderItem(Integer orderId, List<OrderItem> orderItemList){

        String sql = "insert into `order_item`(order_id, product_id, quantity, amount) " +
                "values(:orderId, :productId, :quantity, :amount)";

        MapSqlParameterSource[] params = new MapSqlParameterSource[orderItemList.size()];

        for (int i=0; i < orderItemList.size(); i++) {
            OrderItem orderItem = orderItemList.get(i);

            params[i] = new MapSqlParameterSource();
            params[i].addValue("orderId", orderId);
            params[i].addValue("productId", orderItem.getProduct_Id());
            params[i].addValue("quantity", orderItem.getQuantity());
            params[i].addValue("amount", orderItem.getAmount());
        }

        namedParameterJdbcTemplate.batchUpdate(sql, params);
    }
}
