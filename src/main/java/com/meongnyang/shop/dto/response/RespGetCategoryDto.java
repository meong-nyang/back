package com.meongnyang.shop.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespGetCategoryDto {
    private int id;
    private String categoryName;
}
