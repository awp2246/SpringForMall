package com.bob.springformall.dao.impl;

import com.bob.springformall.dao.ProductDao;
import com.bob.springformall.model.Product;
import com.bob.springformall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Product getProductById(int productId) {
        String sql = "select product_id,\n" +
                "    product_name,\n" +
                "    category,     \n" +
                "    image_url,         \n" +
                "    price,             \n" +
                "    stock,             \n" +
                "    description,       \n" +
                "    created_date,      \n" +
                "    last_modified_date\n" +
                "    from product\n" +
                "    where product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }
}
