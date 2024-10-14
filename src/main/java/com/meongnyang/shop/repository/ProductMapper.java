package com.meongnyang.shop.repository;

import com.meongnyang.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    public Product getProduct(@Param("productId") Long productId);

    public List<Product> getProducts();
}
