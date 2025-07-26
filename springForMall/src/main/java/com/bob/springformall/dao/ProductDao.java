package com.bob.springformall.dao;

import com.bob.springformall.constant.ProductCategory;
import com.bob.springformall.dto.ProductQueryParam;
import com.bob.springformall.dto.ProductRequest;
import com.bob.springformall.model.Product;

import java.util.List;

public interface ProductDao {

    Product getProductById(int productId);

    List<Product> getProducts(ProductQueryParam param);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
