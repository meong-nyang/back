package com.meongnyang.shop.entity;

import com.meongnyang.shop.dto.response.admin.RespProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private int productPriceDiscount;
    private String productDetail;
    private String productBrand;
    private String productModel;
    private String productMemo;
    private LocalDate productCreateDate;
    private LocalDate productUpdateDate;
    private Long recommendation;

    private List<ImgUrl> imgUrls;
    private PetGroup petGroup;
    private Category category;
    private Stock stock;
    //재고 테이블

    public RespProductDto toDto(List<String> imgs) {
        return RespProductDto.builder()
                .id(id)
                .productName(productName)
                .petGroupId(petGroupId)
                .categoryId(categoryId)
                .productPrice(productPrice)
                .productPriceDiscount(productPriceDiscount)
                .productDetail(productDetail)
                .productBrand(productBrand)
                .productModel(productModel)
                .productMemo(productMemo)
                .productCreateDate(productCreateDate.toString())
                .productUpdateDate(productUpdateDate.toString())
                .recommendation(recommendation)
                .imgs(imgs)
                .petGroup(petGroup)
                .category(category)
                .build();
    }
}
