package com.meongnyang.shop.dto.response;

import com.meongnyang.shop.entity.CategoryProductList;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespCategoryProductListDto {

    private Long categoryId;
    private List<CategoryProductList> products;
    private int productListCount;
}