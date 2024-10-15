package com.meongnyang.shop.repository;

import com.meongnyang.shop.entity.Category;
import com.meongnyang.shop.entity.ProductList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OptionMapper {
    List<ProductList> findAllByStartIndexAndLimit(
            @Param("startIndex") Long startIndex,
            @Param("limit") Long limit);

    Category getCategories();
}
