package com.meongnyang.shop.controller.user;

import com.meongnyang.shop.dto.request.ReqGetCartDto;
import com.meongnyang.shop.service.product.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    public CartService cartService;


//    @GetMapping("/user/cart")
//    public ResponseEntity<?> getCartAll(ReqGetCartDto dto) {
//        return ResponseEntity.ok().body(cartService.);
//    }
}
