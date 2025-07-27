package com.bob.springformall.dao.impl;

import com.bob.springformall.constant.ProductCategory;
import com.bob.springformall.dao.ProductDao;
import com.bob.springformall.dto.ProductQueryParam;
import com.bob.springformall.dto.ProductRequest;
import com.bob.springformall.model.Product;
import com.bob.springformall.rowmapper.ProductRowMapper;
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

    @Override
    public List<Product> getProducts(ProductQueryParam param) {
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
                "    where 1=1";

        Map<String, Object> map = new HashMap<>();

        if(param.getCategory() != null){
            sql = sql + " AND category = :category";
            map.put("category", param.getCategory().name());
        }

        if(param.getSearch() != null){
            sql = sql + " AND product_name LIKE :search";
            map.put("search", "%" + param.getSearch() + "%");
        }


        //排序
        sql = sql + " ORDER BY "  + param.getOrderBy() + " " + param.getSort();
        //分頁
        sql = sql + " LIMIT :limit OFFSET :offset";
        map.put("limit", param.getLimit());
        map.put("offset", param.getOffset());

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }


    @Override
    public  int countProducts(ProductQueryParam param) {

        String sql = "select count(*) from product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        if(param.getCategory() != null){
            sql = sql + " AND category = :category";
            map.put("category", param.getCategory().name());
        }

        if(param.getSearch() != null){
            sql = sql + " AND product_name LIKE :search";
            map.put("search", "%" + param.getSearch() + "%");
        }

        Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
        return total;
    }



    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product(product_name, category, image_url, price, stock, description, created_date, last_modified_date) " +
                     "VALUES(:productName, :category, :imageUrl, :price, :stock, :description, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int  productId = keyHolder.getKey().intValue();

        return productId;

    }

    @Override
    public void updateProduct(int productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name = :productName, category = :category, image_url = :imageUrl, " +
                "price = :price,  stock = :stock, description = :description, " +
                "last_modified_date = :lastModifiedDate "  +
                "WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public void deleteProductById(Integer productId) {

        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        namedParameterJdbcTemplate.update(sql,map);
    }

}
