package com.meongnyang.shop.repository;

import com.meongnyang.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    int save(Product product);
    int findProductsCount();
    int findProductsCountByOption(@Param("option") String option, @Param("searchWord") String searchWord);
    List<Product> findProducts();
    List<Product> findProductsByOption(Map<String, Object> params);
    int modifyProduct(Product product);
    int deleteProductAll();
    int deleteProductById(List<Long> idList);
    Product findProductDetailById(Long id);

    List<Product> findProductsPage(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("petGroupId") int petGroupId,
            @Param("categoryId") int categoryId,
            @Param("orderBy") String orderBy);
    List<Product> findProductsList();
    Product findProductById(Long id);
    int findCategoriesCount(
            @Param("petGroupId") int petGroupId,
            @Param("categoryId") int categoryId,
            @Param("searchWord") String searchWord);
}
