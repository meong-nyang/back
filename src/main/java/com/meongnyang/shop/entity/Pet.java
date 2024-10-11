package com.meongnyang.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private Long petId;
    private String petName;
    private Long petAge;
    private String petType;
}
