package com.meongnyang.shop.dto.request;

import lombok.Data;

@Data
public class ReqProductsCountDto {
    private Long count;
    private Long id;
    private Long petGroupId;
    private Long categoryId;
}