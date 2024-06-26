package cifo2024.losProfesionales.service;

import cifo2024.losProfesionales.model.Competence;
import cifo2024.losProfesionales.model.Employer;
import cifo2024.losProfesionales.model.Professional;
import cifo2024.losProfesionales.repository.ProfessionalRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class ProfessionalService {
    @Autowired
    ProfessionalRepository professionalRepository;
    @Autowired
    CompetenceService competenceService;


public Iterable<Professional> getAllProfessionals() {
    return professionalRepository.findAll();
}

public void populate() {
        // locale in español
        Faker faker = new Faker(new Locale("es-ES"));

        String uniqueID;
        //generamos 8 profesionales Fake
        for (int i = 0; i < 8; i++) {
            uniqueID = UUID.randomUUID().toString();
            Professional professional = new Professional();
            //lista de competencias del profesional
            List<Competence> professionalCompetences;

            //hora de creación del perfil de profesional
            Instant instant = Instant.now();
            long timeStampMillis = instant.toEpochMilli();

            professional.setId(uniqueID);
            professional.setDischargeDate(timeStampMillis);
            professional.setName(faker.name().firstName());
            professional.setEmail(faker.internet().emailAddress());
            professional.setPassword(faker.internet().password(4,6));
            professional.setDniNif(faker.number().digits(9));
            professional.setCompanyName(faker.funnyName().toString());

        //------------- Creamos la Fake list de 4 Competencias
            professionalCompetences = competenceService.createFakeCompetences();
        //----- añadimos el profesional a su competencia correspondiente de la relación
            for (Competence competence : professionalCompetences) {
                professional.addCompetence(competence);
            }
            professionalRepository.save(professional);

        }

    }
}
