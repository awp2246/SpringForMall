package com.bob.springformall.service;

import com.bob.springformall.constant.ProductCategory;
import com.bob.springformall.dto.ProductQueryParam;
import com.bob.springformall.dto.ProductRequest;
import com.bob.springformall.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {

    Product getProductById(int productId);

    List<Product> getProducts(ProductQueryParam param);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

}
