package com.family.app.domain;

import com.family.app.domain.model.FamilyData;
import com.family.app.domain.model.FamilySimpleData;
import com.family.app.infrastructure.repository.FamilyMemberRepository;
import com.family.app.infrastructure.repository.FamilyRepository;
import com.family.app.infrastructure.entity.Family;
import com.family.app.infrastructure.entity.FamilyMember;
import com.family.app.exception.vo.BadRequestException;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FamilyService {
    private FamilyRepository familyRepo;
    private FamilyMemberRepository familyMemberRepo;

    public UUID createFamily(FamilyData dto) {
        Family family = dto.getFamilyEntity();
        UUID id = familyRepo.save(family).getId();
        dto.getMembers().forEach(member->{
            FamilyMember familyMember = member.toFamilyMemberEntity(id);
            familyMemberRepo.save(familyMember);
        });
        return id;
    }

    public FamilyData getFamily(UUID id) {
        Optional<Family> familyOpt = familyRepo.findById(id);
        if(familyOpt.isPresent()){
            Family family = familyOpt.get();
            List<FamilyMember> members = familyMemberRepo.findByFamilyId(family.getId());
            return FamilyData.of(family, members);
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
