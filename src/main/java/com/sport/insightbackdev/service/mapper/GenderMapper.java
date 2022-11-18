package com.sport.insightbackdev.service.mapper;

import com.sport.insightbackdev.model.enums.Gender;
import org.springframework.stereotype.Component;

import static com.sport.sport.insightbackdev.model.Gender.FEMALE;
import static com.sport.sport.insightbackdev.model.Gender.MALE;

@Component
public class GenderMapper {

    public static Gender mapToGender(com.sport.sport.insightbackdev.model.Gender gender){
        return switch (gender){
            case MALE -> Gender.MALE;
            case FEMALE -> Gender.FEMALE;
        };
    }

    public static com.sport.sport.insightbackdev.model.Gender mapToGender(Gender gender){
        return switch (gender){
            case MALE -> MALE;
            case FEMALE -> FEMALE;
        };
    }
}
