package com.meongnyang.shop.service.user;

import com.meongnyang.shop.dto.request.user.*;
import com.meongnyang.shop.dto.response.user.RespGetCartDto;
import com.meongnyang.shop.dto.response.user.RespPostCartDto;
import com.meongnyang.shop.entity.*;
import com.meongnyang.shop.exception.DeleteException;
import com.meongnyang.shop.exception.UserNotAuthenticatedException;
import com.meongnyang.shop.repository.ImgUrlMapper;
import com.meongnyang.shop.repository.user.MyPageMapper;
import com.meongnyang.shop.repository.user.UserCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserCartService {

    @Autowired
    MyPageMapper myPageMapper;

    @Autowired
    ImgUrlMapper imgUrlMapper;

    @Autowired
    UserCartMapper userCartMapper;

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UserNotAuthenticatedException("로그인을 다시해주세요");
        }
        return myPageMapper.findUserByUsername(authentication.getName());
    }

    public RespPostCartDto saveCart(ReqPostCartDto dto) {
        User user = getCurrentUser();
        Long currentUserId = user.getId();
        Cart existingCart = userCartMapper.findCartByUserProductId(dto.getUserId(), dto.getProductId());

        if (!currentUserId.equals(dto.getUserId())) {
            throw new SecurityException("사용자 ID가 일치하지 않습니다");
        }

        if (existingCart != null) {
            existingCart.setProductCount(existingCart.getProductCount() + dto.getProductCount());
            userCartMapper.updateCart(existingCart);
            System.out.println("update실행");

            return RespPostCartDto.builder()
                    .userId(existingCart.getUserId())
                    .productId(existingCart.getProductId())
                    .productCount(existingCart.getProductCount())
                    .build();
        }

        Cart cart = Cart.builder()
                .userId(user.getId())
                .productId(dto.getProductId())
                .productCount(dto.getProductCount())
                .build();

        userCartMapper.saveCart(cart);
        System.out.println("save실행");

        return RespPostCartDto.builder()
                .userId(cart.getUserId())
                .productId(cart.getProductId())
                .productCount(cart.getProductCount())
                .build();
    }

    public RespGetCartDto getCartAll(ReqGetCartAllDto dto) {
        User user = getCurrentUser();
        Long currentUserId = user.getId();

        if (!currentUserId.equals(dto.getUserId())) {
            throw new SecurityException("사용자 ID가 일치하지 않습니다");
        }

        Long startIndex = (dto.getPage() - 1) * dto.getLimit();
        Map<String, Object> params = Map.of(
                "startIndex", startIndex,
                "limit", dto.getLimit(),
                "userId", dto.getUserId()
        );

        List<Cart> cartList = userCartMapper.getCart(params);

        List<RespGetCartDto.CartContent> cartContentList = cartList.stream()
                .map(cart -> {
                    ImgUrl imgUrl = imgUrlMapper.findImgNameByProductId(cart.getProductId());
                    return cart.toDto(imgUrl != null ?imgUrl.getImgName() : "");
                })
                .collect(Collectors.toList());

        return RespGetCartDto.builder()
                .cartList(cartContentList)
                .cartListCount(cartList.size())
                .build();
    }

    public int getCartAllCount(ReqGetCartAllCountDto dto) {

        User user = getCurrentUser();
        Long currentUserId = user.getId();

        if (currentUserId.equals(dto.getUserId())) {
            return userCartMapper.findCartCount(currentUserId);
        }
        throw new SecurityException("사용자 ID가 일치하지 않습니다");
    }

    @Transactional(rollbackFor = DeleteException.class)
    public void deleteCartAll(List<Long> userId) {
        User user = getCurrentUser();
        Long currentUserId = user.getId();
        try {
            if (userId != null && userId.contains(currentUserId)) {
                userCartMapper.deleteCartAll(Collections.singletonList(currentUserId));
            } else {
                throw new SecurityException("사용자 ID가 일치하지 않습니다");
            }
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Transactional(rollbackFor = DeleteException.class)
    public void deleteCart(ReqDeleteCartDto dto) {
        User user = getCurrentUser();
        Long currentUserId = user.getId();
        try {
            if (dto.getUserId() != null && dto.getUserId().equals(currentUserId)) {
                List<Long> deleteCartIds = dto.getCartIds();
                userCartMapper.deleteCartById(deleteCartIds);
            } else {
                throw new SecurityException("사용자 ID가 일치하지 않습니다");
            }
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }
}
