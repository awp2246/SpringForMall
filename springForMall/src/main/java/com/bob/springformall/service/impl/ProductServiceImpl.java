package com.bob.springformall.service.impl;

import com.bob.springformall.constant.ProductCategory;
import com.bob.springformall.dao.ProductDao;
import com.bob.springformall.dto.ProductRequest;
import com.bob.springformall.model.Product;
import com.bob.springformall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(int productId) {

        return productDao.getProductById(productId);
    }

    public List<Product> getProducts(ProductCategory category, String search) {
        return productDao.getProducts(category, search);

    }

    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    public void updateProduct(int productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    public void deleteProduct(Integer productId) {
        productDao.deleteProductById(productId);
    }

}
