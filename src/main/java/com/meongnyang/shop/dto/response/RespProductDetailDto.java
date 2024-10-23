package com.meongnyang.shop.dto.response;

import com.meongnyang.shop.dto.response.admin.RespProductDto;
import com.meongnyang.shop.entity.Category;
import com.meongnyang.shop.entity.ImgUrl;
import com.meongnyang.shop.entity.PetGroup;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class RespProductDetailDto {
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
}