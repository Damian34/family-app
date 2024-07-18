package com.family.infra.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "family")
@NoArgsConstructor
@Data
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "nr_of_infants")
    private int nrOfInfants;
    @Column(name = "nr_of_children")
    private int nrOfChildren;
    @Column(name = "nr_of_adults")
    private int nrOfAdults;

    public Family(String name, int nrOfInfants, int nrOfChildren, int nrOfAdults) {
        this.name = name;
        this.nrOfInfants = nrOfInfants;
        this.nrOfChildren = nrOfChildren;
        this.nrOfAdults = nrOfAdults;
    }
}
