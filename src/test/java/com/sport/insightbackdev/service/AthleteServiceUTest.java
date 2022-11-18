package com.sport.insightbackdev.service;

import com.sport.insightbackdev.helper.CreateModel;
import com.sport.insightbackdev.model.Athlete;
import com.sport.insightbackdev.model.enums.Gender;
import com.sport.insightbackdev.repository.AthleteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AthleteServiceUTest {

    @InjectMocks
    private AthleteService athleteService;

    @Mock
    private AthleteRepository athleteRepository;

    @Test
    @DisplayName("Should Get All Athletes")
    void shouldGetAllAthletes() {
        Athlete ruben = CreateModel.createAthleteWithFirstAndLastNameAndGender("Ruben", "Neven", Gender.MALE);
        Athlete remco = CreateModel.createAthleteWithFirstAndLastNameAndGender("Remco", "Evenepoel", Gender.MALE);
        Athlete ann = CreateModel.createAthleteWithFirstAndLastNameAndGender("Ann", "Wauters", Gender.FEMALE);
        Athlete nafi = CreateModel.createAthleteWithFirstAndLastNameAndGender("Nafi", "Thiam", Gender.FEMALE);
        when(athleteService.getAllAthletes()).thenReturn(List.of(ruben, remco, ann, nafi));

        List<Athlete> allAthletes = athleteService.getAllAthletes();

        assertThat(allAthletes.size(), equalTo(4));
        assertThat(allAthletes,
                hasItems(
                        allOf(
                                hasProperty("id", notNullValue()),
                                hasProperty("firstName", equalTo("Ruben")),
                                hasProperty("lastName",  equalTo("Neven")),
                                hasProperty("gender",  equalTo(Gender.MALE)),
                                hasProperty("weight",  equalTo(75F)),
                                hasProperty("height",  equalTo(1.80F))),
                        allOf(
                                hasProperty("id", notNullValue()),
                                hasProperty("firstName", equalTo("Remco")),
                                hasProperty("lastName",  equalTo("Evenepoel")),
                                hasProperty("gender",  equalTo(Gender.MALE)),
                                hasProperty("weight",  equalTo(75F)),
                                hasProperty("height",  equalTo(1.80F))),
                        allOf(
                                hasProperty("id", notNullValue()),
                                hasProperty("firstName", equalTo("Ann")),
                                hasProperty("lastName",  equalTo("Wauters")),
                                hasProperty("gender",  equalTo(Gender.FEMALE)),
                                hasProperty("weight",  equalTo(75F)),
                                hasProperty("height",  equalTo(1.80F))),
                        allOf(
                                hasProperty("id", notNullValue()),
                                hasProperty("firstName", equalTo("Nafi")),
                                hasProperty("lastName",  equalTo("Thiam")),
                                hasProperty("gender",  equalTo(Gender.FEMALE)),
                                hasProperty("weight",  equalTo(75F)),
                                hasProperty("height",  equalTo(1.80F)))));

    }

    @Test
    @DisplayName("Should Create Athlete")
    void shouldCreateAthlete(){
        Athlete ruben = CreateModel.createAthleteWithFirstAndLastNameAndGender("Ruben", "Neven", Gender.MALE);
        when(athleteRepository.save(any(Athlete.class))).thenReturn(ruben);
        Athlete athlete = athleteService.createAthlete(ruben);

        assertThat(athlete, allOf(
                hasProperty("id", notNullValue()),
                hasProperty("firstName", equalTo("Ruben")),
                hasProperty("lastName",  equalTo("Neven")),
                hasProperty("gender",  equalTo(Gender.MALE)),
                hasProperty("weight",  equalTo(75F)),
                hasProperty("height",  equalTo(1.80F)))
        );
    }


    @Test
    @DisplayName("Should Find Athlete By Id")
    void shouldFindAthleteById(){
        Athlete nafi = CreateModel.createAthleteWithFirstAndLastNameAndGender("Nafi", "Thiam", Gender.FEMALE);
        when(athleteRepository.findById(any(Long.class))).thenReturn(Optional.of(nafi));

        Athlete athleteById = athleteService.findAthleteById(1L);

        assertThat(athleteById, allOf(
                hasProperty("id", notNullValue()),
                hasProperty("firstName", equalTo("Nafi")),
                hasProperty("lastName",  equalTo("Thiam")),
                hasProperty("gender",  equalTo(Gender.FEMALE)),
                hasProperty("weight",  equalTo(75F)),
                hasProperty("height",  equalTo(1.80F)))
        );
    }

    @Test
    @DisplayName("Should Throw Element Not Found Exception")
    void shouldThrowElementNotFoundException(){
        doThrow(NoSuchElementException.class).when(athleteRepository).findById(any(Long.class));

        assertThrows(NoSuchElementException.class, () -> athleteService.findAthleteById(99L));

    }
}
