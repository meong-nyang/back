package com.meongnyang.shop.controller.admin;

import com.meongnyang.shop.dto.request.ReqRegisterProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminProductController {

    @PostMapping("/product")
    public ResponseEntity<?> registerProduct(@RequestBody ReqRegisterProductDto dto) {
        System.out.println(dto);
        return ResponseEntity.ok().body(null);
    }
}