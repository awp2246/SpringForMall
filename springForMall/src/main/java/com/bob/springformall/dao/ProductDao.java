package com.bob.springformall.dao;

import com.bob.springformall.dto.ProductRequest;
import com.bob.springformall.model.Product;

public interface ProductDao {

    Product getProductById(int productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
