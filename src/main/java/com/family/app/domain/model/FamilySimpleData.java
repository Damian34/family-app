package com.family.app.domain.model;

import com.family.app.infrastructure.entity.Family;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilySimpleData {
    private UUID id;
    private String name;

    public static FamilySimpleData of(Family family){
        return new FamilySimpleData(family.getId(), family.getName());
    }
}
