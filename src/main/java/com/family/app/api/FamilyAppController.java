package com.family.app.api;

import com.family.app.domain.FamilyService;
import com.family.app.domain.model.FamilyData;
import com.family.app.domain.model.FamilySimpleData;
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
    public String createFamily(@RequestBody FamilyData dto) {
        return familyService.createFamily(dto).toString();
    }

    @DeleteMapping("/delete")
    public void deleteFamily(@RequestParam UUID id){
        familyService.deleteFamily(id);
    }

    @GetMapping
    public ResponseEntity<FamilyData> getFamily(@RequestParam UUID id) {
        return ResponseEntity.ok(familyService.getFamily(id));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<FamilySimpleData>> getAllFamilies(){
        return ResponseEntity.ok(familyService.getAllFamilies());
    }
}
