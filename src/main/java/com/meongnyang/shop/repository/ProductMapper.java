package com.meongnyang.shop.repository;

import com.meongnyang.shop.entity.Product;
import com.meongnyang.shop.entity.ProductList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductList> findAllByStartIndexAndLimit(
            @Param("startIndex") Long startIndex,
            @Param("limit") Long limit);

    int getProductsCount();

    Product findById(Long id);
}
