package cifo2024.losProfesionales;

import cifo2024.losProfesionales.repository.ProfessionalRepository;
import cifo2024.losProfesionales.service.EmployerService;
import cifo2024.losProfesionales.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartFillingDB implements ApplicationRunner {

        //https://javadzone.com/spring-boot-runners-commandline-vs-application/
        @Autowired
        ProfessionalService professionalService;

        @Autowired
        EmployerService employerService;

        @Override
        public void run(ApplicationArguments args) throws Exception {
            populate_H2_DB();
        }

        public void populate_H2_DB(){
            professionalService.populate();
            employerService.populate();

        }
}
