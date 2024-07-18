package com.family;

import com.family.domain.data.FamilyDto;
import com.family.domain.data.FamilyMemberData;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import feign.FeignException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class FamilyAppTests {
    @Autowired
    private TestFamilyClient client;

    @AfterEach
    void cleanUp(){
        Objects.requireNonNull(client.getAllFamily().getBody())
                .forEach(family->client.deleteFamily(family.getId()));
    }

    @Test
    void shouldCreateFamilyTest() {
        //given
        FamilyDto requestDto = new FamilyDto(
                "Kowalski",
                List.of(
                        new FamilyMemberData("Kamil", 3),
                        new FamilyMemberData("Olivier", 12),
                        new FamilyMemberData("Mateusz", 24)
                )
        );

        // when
        String responseId = client.createFamily(requestDto);

        // then
        UUID id = UUID.fromString(responseId);

        //when
        ResponseEntity<FamilyDto> responseDao = client.getFamily(id);

        // then
        assertEquals(responseDao.getStatusCode().value(), 200);
        assertEquals(requestDto.getFamilyName(), responseDao.getBody().getFamilyName());
        client.deleteFamily(id);
    }

    @Test
    void shouldReturnBadRequestWhenTryGetFamilyByNotExistId(){
        // given
        UUID id = UUID.randomUUID();

        // when
        Executable exe = () -> client.getFamily(id);

        // then
        assertThrows(FeignException.BadRequest.class, exe);
    }
}
