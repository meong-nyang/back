package com.meongnyang.shop.service.product;

import com.meongnyang.shop.dto.response.RespGetCategoryDto;
import com.meongnyang.shop.entity.Category;
import com.meongnyang.shop.repository.OptionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOptionService {

    OptionMapper optionMapper;

    public List<RespGetCategoryDto> getProductCategory() {
        List<Category> productCategoryList = optionMapper.getAllCategories();
        return productCategoryList.stream().map(Category::toRespGetCategoryDto).collect(Collectors.toList());
    }
}
