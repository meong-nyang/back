package com.meongnyang.shop.service.product;

import com.meongnyang.shop.dto.request.ReqProductListDto;
import com.meongnyang.shop.dto.response.RespProductDetailDto;
import com.meongnyang.shop.dto.response.RespProductListDto;
import com.meongnyang.shop.entity.Category;
import com.meongnyang.shop.entity.Product;
import com.meongnyang.shop.entity.ProductList;
import com.meongnyang.shop.exception.NotFoundProductException;
import com.meongnyang.shop.repository.OptionMapper;
import com.meongnyang.shop.repository.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public RespProductListDto getProductList(ReqProductListDto dto) {
        Long startIndex = ( dto.getPage() - 1 ) * dto.getLimit();
        List<ProductList> productLists = productMapper.findAllByStartIndexAndLimit(startIndex, dto.getLimit());
        Integer productTotalCount = productMapper.getProductsCount();

        return RespProductListDto.builder()
                .products(productLists)
                .totalCount(productTotalCount)
                .build();
    }

    public RespProductDetailDto getProductDetail(Long productId) {
        Product product = productMapper.findById(productId);

        if(product == null) {
            throw new NotFoundProductException("해당 상품을 찾을 수 없습니다.");
        }

        return RespProductDetailDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .petGroupId(product.getPetGroupId())
                .categoryId(product.getCategoryId())
                .productPrice(product.getProductPrice())
                .productPriceDiscount(product.getProductPriceDiscount())
                .productDetail(product.getProductDetail())
                .productModel(product.getProductModel())
                .productBrand(product.getProductBrand())
                .productMemo(product.getProductMemo())
                .productCreateDate(product.getProductCreateDate())
                .productUpdateDate(product.getProductUpdateDate())
                .recommendation(product.getRecommendation())
                .build();
    }
}
