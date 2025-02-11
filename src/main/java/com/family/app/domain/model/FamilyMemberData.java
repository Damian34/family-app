package com.family.app.domain.model;

import com.family.app.infrastructure.entity.FamilyMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyMemberData {
    private String name;
    private int age;

    public FamilyMember toFamilyMemberEntity(UUID familyId){
        return new FamilyMember(familyId, name, age);
    }
}
