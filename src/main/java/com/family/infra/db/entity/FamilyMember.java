package com.family.infra.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "family_member")
@Data
@NoArgsConstructor
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "family_id")
    private UUID familyId;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public FamilyMember(UUID familyId, String name, int age) {
        this.familyId = familyId;
        this.name = name;
        this.age = age;
    }
}
