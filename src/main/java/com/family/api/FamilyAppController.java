package com.family.api;

import com.family.domain.FamilyService;
import com.family.domain.data.FamilyDto;
import com.family.domain.data.FamilySimpleData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("family")
@AllArgsConstructor
public class FamilyAppController {
    private FamilyService familyService;

    @PostMapping("/create")
    public String createFamily(@RequestBody FamilyDto dto) {
        return familyService.createFamily(dto).toString();
    }

    @DeleteMapping("/delete")
    public void deleteFamily(@RequestParam UUID id){
        familyService.deleteFamily(id);
    }

    @GetMapping
    public ResponseEntity<FamilyDto> getFamily(@RequestParam UUID id) {
        return ResponseEntity.ok(familyService.getFamily(id));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<FamilySimpleData>> getAllFamilies(){
        return ResponseEntity.ok(familyService.getAllFamilies());
    }
}
