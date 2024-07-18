package com.family.infra.db.repository;

import com.family.infra.db.entity.FamilyMember;
import java.util.List;
import java.util.UUID;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, UUID>{

    public List<FamilyMember> findByFamilyId(UUID id);

    @Transactional
    @Modifying
    public void deleteByFamilyId(UUID id);
}
