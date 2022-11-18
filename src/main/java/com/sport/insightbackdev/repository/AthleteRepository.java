package com.sport.insightbackdev.repository;

import com.sport.insightbackdev.model.Athlete;
import com.sport.insightbackdev.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {

/*    public AthleteRepository() {
        athletes.add(ruben);
        athletes.add(sofie);
    }

    List<Athlete> athletes = new ArrayList<>();
    Athlete ruben = new Athlete(1L, "Ruben", "Neven", 1.76F, 74.9F);
    Athlete sofie = new Athlete(2L, "Sofie", "Verryssen", 1.74F, 59.2F);

    public List<Athlete> getAllAthletes(){
        return athletes;
    }

    public Athlete createAthlete(Athlete athlete){
        athletes.add(athlete);
        return athlete;
    }

    public Optional<Athlete> findById(Long id){
        return athletes.stream().filter(a -> a.getId().equals(id)).findFirst();
    }*/
}
