package com.meongnyang.shop.service.product;

import com.meongnyang.shop.dto.response.RespCategoryProductListDto;
import com.meongnyang.shop.repository.OptionMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductOptionService {

    OptionMapper optionMapper;

    public RespCategoryProductListDto getProductCategory(Long categoryId) {

        return RespCategoryProductListDto.builder()
                .build();
    }
}
