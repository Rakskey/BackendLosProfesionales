package cifo2024.losProfesionales.service;

import cifo2024.losProfesionales.model.Competence;
import cifo2024.losProfesionales.repository.CompetenceRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class CompetenceService {

    @Autowired
    CompetenceRepository competenceRepository;

    public Iterable<Competence> getAllCompetences(){
        return competenceRepository.findAll();
    }



    public List<Competence> createFakeCompetences() {

        Faker faker = new Faker(new Locale("es-ES"));
        //grupo de servicios por el momento
        String[] typeOfCompetence = {"FrontEnd","BackEnd", "DevOps"} ;
        String uniqueID;
        List<Competence> competences = new ArrayList<>();

        for (int i=0; i<4; i++){

            Instant instant = Instant.now();
            long timeStampMillis = instant.toEpochMilli();
            uniqueID = UUID.randomUUID().toString();
            Competence competence = new Competence(
                    uniqueID,
                    timeStampMillis,
                    faker.gameOfThrones().character(),
                    faker.lorem().paragraph(2),
                    typeOfCompetence[faker.number().numberBetween(0,3)],
                    Boolean.TRUE, null //el profesional se le asignará en el service de profesional al añadir la competencia con el método addCompetence
            );
            competences.add(competence);
        }
        return competences;
    }

    public Optional<Competence> getCompetenceById(String id ) {
        return competenceRepository.findById(id);
    }
}