package cifo2024.losProfesionales.service;

import cifo2024.losProfesionales.model.Employer;
import cifo2024.losProfesionales.repository.EmployerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Locale;
import java.util.UUID;

@Service
public class EmployerService {

    @Autowired
    EmployerRepository employerRepository;

    public Iterable<Employer> getAllEmployers(){
        return employerRepository.findAll();
    }

    public void populate() {

        // locale in english
        Faker faker = new Faker(new Locale("es-ES"));

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {
            Instant instant = Instant.now();
            long timeStampMillis = instant.toEpochMilli();


            uniqueID = UUID.randomUUID().toString();
            employerRepository.save(
                    new Employer(uniqueID,
                            timeStampMillis,
                            faker.name().firstName(),
                            faker.dune().toString(),
                            faker.number().digits(6),
                            faker.number().toString(),
                            faker.number().toString(),
                            faker.funnyName().toString(),null
                    ));

        }

    }

    //CRUD : Create
    public void newEmployer(Employer newEmployer){

    }
}
