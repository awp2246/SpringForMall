package com.bob.springformall.service;

import com.bob.springformall.dto.ProductRequest;
import com.bob.springformall.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {

    Product getProductById(int productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
