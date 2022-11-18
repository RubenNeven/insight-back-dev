package com.sport.insightbackdev.service.mapper;

import com.sport.insightbackdev.model.Athlete;
import com.sport.sport.insightbackdev.model.AthleteDTO;
import org.springframework.stereotype.Component;

@Component
public class AthleteMapper {
    public static AthleteDTO mapToDto(Athlete athlete){
        AthleteDTO athleteDTO = new AthleteDTO();
        athleteDTO.setGender(GenderMapper.mapToGender(athlete.getGender()));
        athleteDTO.setId(athlete.getId().toString());
        athleteDTO.setFirstName(athlete.getFirstName());
        athleteDTO.setLastName(athlete.getLastName());
        athleteDTO.setHeight(athlete.getHeight());
        athleteDTO.setWeight(athlete.getWeight());
        return athleteDTO;
    }

    public static Athlete mapToEntity(AthleteDTO athleteDTO){
        Athlete athlete = new Athlete();
        athlete.setGender(GenderMapper.mapToGender(athleteDTO.getGender()));
        athlete.setFirstName(athleteDTO.getFirstName());
        athlete.setLastName(athleteDTO.getLastName());
        athlete.setHeight(athleteDTO.getHeight().floatValue());
        athlete.setWeight(athleteDTO.getWeight().floatValue());
        return athlete;
    }
}
