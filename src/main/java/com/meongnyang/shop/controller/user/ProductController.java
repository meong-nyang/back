package com.meongnyang.shop.controller.user;

import com.meongnyang.shop.dto.request.user.ReqProductAllDto;
import com.meongnyang.shop.dto.request.user.ReqProductCountDto;
import com.meongnyang.shop.service.user.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/categorys")
    public ResponseEntity<?> getCategorys() {
        return ResponseEntity.ok().body(productService.getCategorys());
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProductsAll(ReqProductAllDto dto) {
        System.out.println(dto);
        return ResponseEntity.ok().body(productService.getProductsAll(dto));
    }

    @GetMapping("/products/count")
    public ResponseEntity<?> getProductsAllCount(ReqProductCountDto dto) {
        System.out.println("카운트 요청" + dto);
        return ResponseEntity.ok().body(productService.getProductsCount(dto));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProductDetail(@PathVariable Long productId) {
        System.out.println(productId);
        return ResponseEntity.ok().body(productService.getProductDetail(productId));
    }
}
