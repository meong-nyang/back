package com.meongnyang.shop.service.user;

import com.meongnyang.shop.dto.request.ReqGetProductCountDto;
import com.meongnyang.shop.dto.request.ReqGetProductsDto;
import com.meongnyang.shop.dto.response.RespGetProductCountDto;
import com.meongnyang.shop.dto.response.RespProductsDto;
import com.meongnyang.shop.dto.response.admin.RespGetProductsAllDto;
import com.meongnyang.shop.entity.Product;
import com.meongnyang.shop.exception.NotFoundProductException;
import com.meongnyang.shop.repository.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProductService {

    @Autowired
    ProductMapper productMapper;

    public RespGetProductsAllDto getProductsAll() {
        List<Product> productList = productMapper.findProductsList();
        return RespGetProductsAllDto.builder()
                .productList(productList)
                .productListCount(productList.size())
                .build();
    }

    public List<RespProductsDto> productPage(ReqGetProductsDto dto) {
        int startIndex = (dto.getPage() - 1) * dto.getCount();
        List<Product> productList = productMapper.findProductsPage(
                startIndex,
                dto.getCount(),
                dto.getPetGroupId(),
                dto.getCategoryId(),
                dto.getOrderBy());

        return productList.stream().map(Product::toDto).collect(Collectors.toList());
    }

    public RespGetProductCountDto getProductsCount(ReqGetProductCountDto dto) {
        int productCount = productMapper.findCategoriesCount(
                dto.getPetGroupId(),
                dto.getCategoryId(),
                dto.getSearchWord());
        int maxPageNumber = (int) Math.ceil(((double) productCount) / dto.getCount());

        return RespGetProductCountDto.builder()
                .totalCount(productCount)
                .maxPageNumber(maxPageNumber)
                .build();
    }

    public Product getProductDetail(Long productId) {
        Product product = productMapper.findProductDetailById(productId);

        if(product == null) {
            throw new NotFoundProductException("해당 상품을 찾을 수 없습니다.");
        }

        return product;
    }


}