package com.meongnyang.shop.controller.user;

import com.meongnyang.shop.dto.request.ReqProductListDto;
import com.meongnyang.shop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // 전체 상품 조회
    @GetMapping("/products")
    public ResponseEntity<?> getProductsAll(ReqProductListDto dto) {
        return ResponseEntity.ok().body(productService.getProductList(dto));
    }

    // 전체 상품 카운트
//    @GetMapping("/products/count")
//    public ResponseEntity<?> getProductsCount(RespGetProductsCountDto dto) {
//        return ResponseEntity.ok(productService.getProductsCount());
//    }

    // 상세 조회
    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok().body(productService.getBoardDetail(productId));
    }
}
