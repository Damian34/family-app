package com.family.app.domain.model;

import com.family.app.infrastructure.entity.Family;
import com.family.app.infrastructure.entity.FamilyMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyData {
    private String familyName;
    private List<FamilyMemberData> members;

    public static FamilyData of(Family family, List<FamilyMember> members){
        return new FamilyData(
                family.getName(),
                members.stream()
                        .map(member -> new FamilyMemberData(member.getName(), member.getAge()))
                        .toList()
        );
    }

    public Family getFamilyEntity(){
        AtomicInteger infants = new AtomicInteger();
        AtomicInteger children = new AtomicInteger();
        AtomicInteger adults = new AtomicInteger();
        members.forEach(member -> {
            int age = member.getAge();
            if (age >= 0 && age < 4) {
                infants.getAndIncrement();
            } else if (age < 16) {
                children.getAndIncrement();
            } else {
                adults.getAndIncrement();
            }
        });
        return new Family(familyName, infants.get(), children.get(), adults.get());
    }
}
