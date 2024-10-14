package com.meongnyang.shop.controller.user;

import com.meongnyang.shop.service.product.ProductOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOptionController {

    @Autowired
    ProductOptionService productOptionService;

    @GetMapping("/products/categories")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok().body(productOptionService.getProductCategory());
    }

}
