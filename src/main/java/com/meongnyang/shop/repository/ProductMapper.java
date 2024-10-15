package com.meongnyang.shop.repository;

import com.meongnyang.shop.entity.CategoryProductList;
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

    List<CategoryProductList> findAllByCategoryId(Long categoryId);

    int getProductsCount();

    Product findById(Long id);

    Product findByCategoryId(Long categoryId);
}
