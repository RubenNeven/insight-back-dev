package com.sport.insightbackdev.service;

import com.sport.insightbackdev.model.Athlete;
import com.sport.insightbackdev.repository.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }
    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();
    }

    public Athlete findAthleteById(Long id){
       return athleteRepository.findById(id)
               .orElseThrow(() -> new NoSuchElementException("Athlete with id " + id + " not found"));
    }

    public Athlete createAthlete(Athlete athlete){
        return athleteRepository.save(athlete);
    }
}
