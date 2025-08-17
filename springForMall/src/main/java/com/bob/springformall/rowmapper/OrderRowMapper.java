package com.bob.springformall.rowmapper;

import com.bob.springformall.constant.ProductCategory;
import com.bob.springformall.model.Order;
import com.bob.springformall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();

        order.setOrder_Id(rs.getString("order_Id"));
        order.setUser_Id(rs.getInt("user_Id"));
        order.setTotal_amount(rs.getInt("total_amount"));
        order.setCreated_date(rs.getTimestamp("created_date"));
        order.setLast_modified_date(rs.getTimestamp("last_modified_date"));

        return order;
    }
}
