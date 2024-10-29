package com.meongnyang.shop.dto.request.user;

import com.meongnyang.shop.entity.Pet;
import lombok.Data;

@Data
public class ReqUpdatePetDto {
    private Long userId;
    private String petName;
    private Long petAge;
    private String petType;

    public Pet toEntity() {
        return Pet.builder()
                .userId(userId)
                .petName(petName)
                .petAge(petAge)
                .petType(petType)
                .build();
    }
}
