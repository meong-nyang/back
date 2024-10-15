package com.meongnyang.shop.controller.user;

import com.meongnyang.shop.service.product.ProductOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOptionController {

    @Autowired
    ProductOptionService productOptionService;

    // 카테고리별 상품 조회
    @GetMapping("/products/categories/{categoryId}")
    public ResponseEntity<?> getCategories(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(productOptionService.getProductCategory(categoryId));
    }

}
