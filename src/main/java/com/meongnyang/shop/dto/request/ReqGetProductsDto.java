package com.meongnyang.shop.dto.request;

import lombok.Data;

@Data
public class ReqGetProductsDto {
    private int page;
    private int count;
    private int petGroupId;
    private int categoryId;
    private String orderBy;
}
