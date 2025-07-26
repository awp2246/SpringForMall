package com.bob.springformall.controller;

import com.bob.springformall.constant.ProductCategory;
import com.bob.springformall.dto.ProductQueryParam;
import com.bob.springformall.dto.ProductRequest;
import com.bob.springformall.model.Product;
import com.bob.springformall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
    }



    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort)
    {


        ProductQueryParam param = new ProductQueryParam();
        param.setCategory(category);
        param.setSearch(search);
        param.setOrderBy(orderBy);
        param.setSort(sort);

        List<Product> productList = productService.getProducts(param);

        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }



    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }


    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody @Valid ProductRequest productRequest) {

        Product product = productService.getProductById(productId);
        //查詢產品是否存在
        if(product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //若存在才update
        productService.updateProduct(productId, productRequest);

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {

        productService.deleteProduct(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
