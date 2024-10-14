package com.meongnyang.shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespGetProductDto {
    private Long id;
    private String productName;
    private Long petGroupId;
    private Long categoryId;
    private Long productPrice;
    private Long productPriceDiscount;
    private String productDetail;
    private String productBrand;
    private String productModel;
    private String productMemo;
    private LocalDateTime productCreateDate;
    private LocalDateTime productUpdateDate;
    private Long recommendation;
}
