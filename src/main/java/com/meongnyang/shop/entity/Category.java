package com.meongnyang.shop.entity;

import com.meongnyang.shop.dto.response.RespGetCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int id;
    private String categoryName;

    public RespGetCategoryDto toRespGetCategoryDto() {
        return RespGetCategoryDto.builder()
                .id(id)
                .categoryName(categoryName)
                .build();
    }
}