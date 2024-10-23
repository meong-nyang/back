package com.meongnyang.shop.controller.user;

import com.meongnyang.shop.dto.request.ReqGetProductCountDto;
import com.meongnyang.shop.dto.request.ReqGetProductsDto;
import com.meongnyang.shop.service.user.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private UserProductService userProductService;

    // 전체 상품 조회
    @GetMapping("/products")
    public ResponseEntity<?> getProductsAll() {
        return ResponseEntity.ok().body(userProductService.getProductsAll());
    }

    // 전체, 카테고리별 페이지 조회
    @GetMapping("/products/page")
    public ResponseEntity<?> getProducts(ReqGetProductsDto dto){
        return ResponseEntity.ok().body(userProductService.productPage(dto));
    }

    // 전체, 카테고리별 상품 갯수 조회
    @GetMapping("/products/categories/count")
    public ResponseEntity<?> getProductsCount(ReqGetProductCountDto dto) {
        return ResponseEntity.ok(userProductService.getProductsCount(dto));
    }

    // 상세 내용 조회
    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductDetail(@PathVariable Long productId) {
        return ResponseEntity.ok().body(userProductService.getProductDetail(productId));
    }
}