package com.meongnyang.shop.service.product;

import com.meongnyang.shop.dto.response.RespGetProductsDto;
import com.meongnyang.shop.entity.Product;
import com.meongnyang.shop.repository.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public List<RespGetProductsDto> getProducts() {
        List<Product> list = productMapper.getProducts();
        return list.stream().map(Product::toRespGetProductsDto).collect(Collectors.toList());
    }
}
