package com.meongnyang.shop.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespGetCartDto {
    private Long productCartId;
    private Long userId;
    private Long productId;
    private Long productCartCount;
}
