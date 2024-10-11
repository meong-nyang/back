package com.meongnyang.shop.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespPetInfoDto {
    private Long id;
    private String petName;
    private Long petAge;
    private String petType;
}
