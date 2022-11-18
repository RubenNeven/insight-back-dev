package com.sport.insightbackdev.controller;

import com.sport.insightbackdev.helper.CreateModel;
import com.sport.insightbackdev.model.Athlete;
import com.sport.insightbackdev.repository.AthleteRepository;
import com.sport.sport.insightbackdev.model.AthleteDTO;
import com.sport.sport.insightbackdev.model.Gender;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:/application-test.properties"})
class AthleteControllerITest {

    @LocalServerPort
    private int port;

    @Autowired
    private AthleteRepository athleteRepository;

    @BeforeAll
    void setup() {
        Athlete rubenNeven = CreateModel.createAthleteWithOutId("Ruben", "Neven", com.sport.insightbackdev.model.enums.Gender.MALE);
        athleteRepository.save(rubenNeven);
        Athlete woutVanAert = CreateModel.createAthleteWithOutId("Wout", "Van Aert", com.sport.insightbackdev.model.enums.Gender.MALE);
        athleteRepository.save(woutVanAert);
        Athlete lucyCharles = CreateModel.createAthleteWithOutId("Lucy", "Charles", com.sport.insightbackdev.model.enums.Gender.FEMALE);
        athleteRepository.save(lucyCharles);

    }

    @Test
    @DisplayName("Should Get All Athletes")
    void shouldGetAllAthlets() {
        WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build()
                .get()
                .uri("athlete/findAll")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    @DisplayName("Should Get Athlete By ID")
    void shouldGetAthletById() {
        WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build()
                .get()
                .uri("athlete/1")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("firstName").isEqualTo("Ruben")
                .jsonPath("lastName").isEqualTo("Neven")
                .jsonPath("gender").isEqualTo(Gender.MALE.getValue())
                .jsonPath("weight").isEqualTo(75.0F)
                .jsonPath("height").isEqualTo(1.8F);
    }

    @Test
    @DisplayName("Should Throw Error When Athlete Not Found")
    void shouldThrowErrorWhenAthleteNotFound() {
        WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build()
                .get()
                .uri("athlete/99")
                .exchange()
                .expectStatus()
                .isNotFound();
    }


    @Test
    @DisplayName("Should Create Athlete")
    void shouldCreateAthlete() {

        AthleteDTO wva = CreateModel.createAthleteDTO("Wout", "Van Aert", Gender.MALE);

        WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build()
                .post()
                .uri("athlete/createAthlete")
                .contentType(APPLICATION_JSON)
                .body(BodyInserters.fromValue(wva))
                .exchange()
                .expectStatus()
                .isCreated();
    }
}
