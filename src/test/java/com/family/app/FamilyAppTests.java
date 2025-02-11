package com.family.app;

import com.family.app.domain.model.FamilyData;
import com.family.app.domain.model.FamilyMemberData;

import feign.FeignException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
class FamilyAppTests {
    @Autowired
    private TestFamilyClient client;

    @AfterEach
    void cleanUp() {
        Objects.requireNonNull(client.getAllFamily().getBody())
                .forEach(family -> client.deleteFamily(family.getId()));
    }

    @Test
    void shouldCreateFamilyTest() {
        //given
        FamilyData requestDto = new FamilyData(
                "Wądołowski",
                List.of(
                        new FamilyMemberData("Kamil", 3),
                        new FamilyMemberData("Mateusz", 12),
                        new FamilyMemberData("Damian", 24)
                )
        );

        // when
        String responseId = client.createFamily(requestDto);

        // then
        UUID id = UUID.fromString(responseId);
        ResponseEntity<FamilyData> responseDao = client.getFamily(id);
        Assertions.assertEquals(200, responseDao.getStatusCode().value());
        Assertions.assertEquals(requestDto.getFamilyName(), responseDao.getBody().getFamilyName());
        client.deleteFamily(id);
    }

    @Test
    void shouldReturnBadRequestWhenTryGetFamilyByNotExistId(){
        // given
        UUID id = UUID.randomUUID();

        // when and then
        Assertions.assertThrows(FeignException.BadRequest.class, () -> client.getFamily(id));
    }
}
