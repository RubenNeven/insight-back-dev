package com.sport.insightbackdev.controller;

import com.sport.insightbackdev.model.Athlete;
import com.sport.insightbackdev.service.AthleteService;
import com.sport.insightbackdev.service.mapper.AthleteMapper;

import com.sport.sport.insightbackdev.api.AthleteApi;
import com.sport.sport.insightbackdev.model.AthleteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "${cors.allowed.origins}", allowedHeaders = "*", allowCredentials = "true")
public class AthleteController implements AthleteApi {

    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @Override
    public ResponseEntity<List<AthleteDTO>> getAllAthletes() throws Exception {
        List<AthleteDTO> athleteDTOS = athleteService.getAllAthletes().stream().map(AthleteMapper::mapToDto).collect(Collectors.toList());
        return new ResponseEntity<>(athleteDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> createAthlete(AthleteDTO athleteDTO) throws Exception {
        Athlete athlete = athleteService.createAthlete(AthleteMapper.mapToEntity(athleteDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AthleteDTO> getAthletesById(String id) throws Exception {
        AthleteDTO athleteDTO = AthleteMapper.mapToDto(athleteService.findAthleteById(Long.valueOf(id)));
        return new ResponseEntity<>(athleteDTO, HttpStatus.OK);
    }
}
