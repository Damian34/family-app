package com.family.app;

import com.family.app.domain.model.FamilyData;
import com.family.app.domain.model.FamilySimpleData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "familyClient", url="localhost:8080/family")
public interface TestFamilyClient {

    @PostMapping("/create")
    String createFamily(@RequestBody FamilyData dao);

    @DeleteMapping("/delete")
    void deleteFamily(@RequestParam UUID id);

    @GetMapping
    ResponseEntity<FamilyData> getFamily(@RequestParam UUID id);

    @GetMapping("/all")
    ResponseEntity<List<FamilySimpleData>> getAllFamily();
}
