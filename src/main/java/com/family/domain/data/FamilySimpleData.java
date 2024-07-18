package com.family.domain.data;

import com.family.infra.db.entity.Family;
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
