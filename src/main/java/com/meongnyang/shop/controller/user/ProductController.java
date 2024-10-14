package com.meongnyang.shop.controller.user;

import com.meongnyang.shop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    // 전체 상품 조회
    @GetMapping("/products")
    public ResponseEntity<?> getProductsAll() {
        return ResponseEntity.ok().body(productService.getProducts());
    }
}
