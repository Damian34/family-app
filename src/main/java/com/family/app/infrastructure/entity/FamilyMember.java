package com.family.app.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
