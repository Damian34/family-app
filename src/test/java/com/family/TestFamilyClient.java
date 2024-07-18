package com.family;

import com.family.domain.data.FamilyDto;
import com.family.domain.data.FamilySimpleData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "familyClient", url="localhost:8080/family")
public interface TestFamilyClient {

    @PostMapping("/create")
    public String createFamily(@RequestBody FamilyDto dao);

    @DeleteMapping("/delete")
    public void deleteFamily(@RequestParam UUID id);

    @GetMapping
    public ResponseEntity<FamilyDto> getFamily(@RequestParam UUID id);

    @GetMapping("/all")
    public ResponseEntity<List<FamilySimpleData>> getAllFamily();
}
