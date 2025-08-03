package com.bob.springformall.rowmapper;

import com.bob.springformall.constant.ProductCategory;
import com.bob.springformall.model.Product;
import com.bob.springformall.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setUserId(rs.getInt("user_Id"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setCreatedDate(rs.getDate("created_Date"));
        user.setLastModifiedDate(rs.getDate("last_Modified_Date"));

        return user;
    }
}
