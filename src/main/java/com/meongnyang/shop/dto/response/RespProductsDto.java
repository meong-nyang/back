package com.meongnyang.shop.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespProductsDto {
    private Long productId;
    private String productName;
    private String productBrand;
    private Long productPrice;
    private Long petGroupId;
    private String petGroupName;
    private Long categoryId;
    private String categoryName;
    private Long ImgUrlId;
    private String imgPath;
    private String imgName;
}
