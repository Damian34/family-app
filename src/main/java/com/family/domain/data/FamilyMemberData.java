package com.family.domain.data;

import com.family.infra.db.entity.FamilyMember;
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
