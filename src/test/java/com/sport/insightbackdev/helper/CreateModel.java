package com.sport.insightbackdev.helper;

import com.sport.insightbackdev.model.Athlete;
import com.sport.insightbackdev.model.enums.Gender;
import com.sport.sport.insightbackdev.model.AthleteDTO;

import java.math.BigDecimal;
import java.util.Random;

public class CreateModel {

    public static Athlete createAthleteWithOutId(String firstName, String lastName, Gender gender){
        Athlete athlete = new Athlete();
        athlete.setWeight(75F);
        athlete.setHeight(1.80F);
        athlete.setFirstName(firstName);
        athlete.setLastName(lastName);
        athlete.setGender(gender);
        return athlete;
    }

    public static Athlete createAthleteWithFirstAndLastNameAndGender(String firstName, String lastName, Gender gender){
        Athlete athlete = new Athlete();
        athlete.setId(new Random().nextLong());
        athlete.setWeight(75F);
        athlete.setHeight(1.80F);
        athlete.setFirstName(firstName);
        athlete.setLastName(lastName);
        athlete.setGender(gender);
        return athlete;
    }

    public static AthleteDTO createAthleteDTO(String firstName, String lastName, com.sport.sport.insightbackdev.model.Gender gender){
        AthleteDTO athleteDTO = new AthleteDTO();
        athleteDTO.setFirstName(firstName);
        athleteDTO.setLastName(lastName);
        athleteDTO.setGender(gender);
        athleteDTO.setHeight(1.80F);
        athleteDTO.setWeight(75F);
        return athleteDTO;
    }
}
