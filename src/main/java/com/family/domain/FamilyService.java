package com.family.domain;

import com.family.domain.data.FamilyDto;
import com.family.domain.data.FamilySimpleData;
import com.family.infra.db.repository.FamilyMemberRepository;
import com.family.infra.db.repository.FamilyRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.family.infra.db.entity.Family;
import com.family.infra.db.entity.FamilyMember;
import com.family.infra.error.vo.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {
    @Autowired
    private FamilyRepository familyRepo;
    @Autowired
    private FamilyMemberRepository familyMemberRepo;

    public UUID createFamily(FamilyDto dto) {
        Family family = dto.getFamilyEntity();
        UUID id = familyRepo.save(family).getId();
        dto.getMembers().forEach(member->{
            FamilyMember familyMember = member.toFamilyMemberEntity(id);
            familyMemberRepo.save(familyMember);
        });
        return id;
    }

    public FamilyDto getFamily(UUID id) {
        Optional<Family> familyOpt = familyRepo.findById(id);
        if(familyOpt.isPresent()){
            Family family = familyOpt.get();
            List<FamilyMember> members = familyMemberRepo.findByFamilyId(family.getId());
            return FamilyDto.of(family, members);
        }
        throw new BadRequestException("not found family with given id");
    }

    public List<FamilySimpleData> getAllFamilies(){
        return familyRepo.findAll().stream()
                .map(FamilySimpleData::of)
                .toList();
    }

    public void deleteFamily(UUID id){
        familyRepo.deleteById(id);
        familyMemberRepo.deleteByFamilyId(id);
    }
}
