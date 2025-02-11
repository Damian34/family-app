package com.family.app.infrastructure.repository;

import com.family.app.infrastructure.entity.FamilyMember;
import java.util.List;
import java.util.UUID;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, UUID>{

    List<FamilyMember> findByFamilyId(UUID id);

    @Transactional
    @Modifying
    void deleteByFamilyId(UUID id);
}
