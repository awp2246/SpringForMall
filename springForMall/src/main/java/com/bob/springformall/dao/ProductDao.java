package com.bob.springformall.dao;

import com.bob.springformall.model.Product;

public interface ProductDao {

    Product getProductById(int productId);
}
