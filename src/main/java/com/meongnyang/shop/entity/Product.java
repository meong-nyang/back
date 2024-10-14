package com.meongnyang.shop.entity;

import com.meongnyang.shop.dto.response.RespGetProductsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
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
    private Long recommendation;

//    private List<ImgUrl> imgUrls;
//    private PetGroup petGroup;
//    private Category category;


    public RespGetProductsDto toRespGetProductsDto() {
        return RespGetProductsDto.builder()
                .id(getId())
                .productName(getProductName())
                .petGroupId(getPetGroupId())
                .categoryId(getCategoryId())
                .productPrice(getProductPrice())
                .productPriceDiscount(getProductPriceDiscount())
                .productDetail(getProductDetail())
                .productBrand(getProductBrand())
                .productModel(getProductModel())
                .productMemo(getProductMemo())
                .recommendation(getRecommendation())
                .build();
    }
}
