package com.meongnyang.shop.controller.user;

import com.meongnyang.shop.dto.request.ReqProductListDto;
import com.meongnyang.shop.dto.request.ReqProductsCountDto;
import com.meongnyang.shop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // 전체 상품 조회
    @GetMapping("/products")
    public ResponseEntity<?> getProductsAll(@RequestBody ReqProductListDto dto) {
        return ResponseEntity.ok().body(productService.getProductList(dto));
    }

    // 카테고리별 상품 조회
    @GetMapping("/products/categories/{categoryId}")
    public ResponseEntity<?> getProductsAll(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(productService.getCategoryProductList(categoryId));
    }

    // 상세 내용 조회
    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok().body(productService.getProductDetail(productId));
    }
}
