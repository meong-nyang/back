package com.meongnyang.shop.dto.request;

import com.meongnyang.shop.entity.Pet;
import lombok.Data;

@Data
public class ReqUpdatePetDto {
    private Long id;
    private String petName;
    private Long petAge;
    private String petType;

    public Pet toEntity() {
        return Pet.builder()
                .id(id)
                .petName(petName)
                .petAge(petAge)
                .petType(petType)
                .build();
    }
}
