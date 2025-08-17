package com.bob.springformall.rowmapper;

import com.bob.springformall.model.Order;
import com.bob.springformall.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemRowMapper implements RowMapper<OrderItem> {

    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {

        OrderItem orderItem = new OrderItem();

        orderItem.setOrder_Id(rs.getInt("order_id"));
        orderItem.setOrder_item_Id(rs.getInt("order_item_id"));
        orderItem.setProduct_Id(rs.getInt("product_id"));
        orderItem.setQuantity(rs.getInt("quantity"));
        orderItem.setAmount(rs.getInt("amount"));

        orderItem.setProduct_Name(rs.getString("product_name"));
        orderItem.setImage_url(rs.getString("image_url"));

        return orderItem;
    }


}
