package cifo2024.losProfesionales.service;

import cifo2024.losProfesionales.model.Competence;
import cifo2024.losProfesionales.model.Employer;
import cifo2024.losProfesionales.model.Professional;
import cifo2024.losProfesionales.model.Project;
import cifo2024.losProfesionales.repository.CompetenceRepository;
import cifo2024.losProfesionales.repository.EmployerRepository;
import cifo2024.losProfesionales.repository.ProfessionalRepository;
import cifo2024.losProfesionales.repository.ProjectRepository;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;


    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private CompetenceRepository competenceRepository;


    @Transactional
    public void populateProjects(int numOfProjects) {
        Random random = new Random();
        Faker faker = new Faker(new Locale("es-ES"));

        // Obtener todos los empleadores y profesionales una sola vez
        List<Employer> employers = new ArrayList<>();
        employerRepository.findAll().forEach(employers::add);

        List<Professional> professionals = new ArrayList<>();
        professionalRepository.findAll().forEach(professionals::add);

        for (int i = 0; i < numOfProjects; i++) {
            String uniqueID = UUID.randomUUID().toString();
            Instant instant = Instant.now();
            long timeStampMillis = instant.toEpochMilli();

            Employer randomEmployer = employers.get(random.nextInt(employers.size()));
            Professional randomProfessional = professionals.get(faker.random().nextInt(0,(professionals.size()-1)));

            Project project = new Project();
            project.setId(uniqueID);
            project.setEmployer(randomEmployer);
            project.setProfessional(randomProfessional);

            // Obtener una competencia aleatoria del profesional seleccionado
            List<Competence> competences = competenceRepository.findByProfessional(randomProfessional);
            if (!competences.isEmpty()) {
                Competence randomCompetence = competences.get(random.nextInt(competences.size()));
                project.setCompetence(randomCompetence);
            }

            // Establecer el estado del proyecto y otras propiedades
            project.setProjectState("In Progress");
            project.setProjectDates(new Long[]{timeStampMillis, System.currentTimeMillis(), System.currentTimeMillis() + 86400000L});

            // Añadir el proyecto al empleador y al profesional
            randomEmployer.addProject(project);
            randomProfessional.addProject(project);
/*

            employerRepository.save(randomEmployer);
            professionalRepository.save(randomProfessional);

*/

/*   El hecho de intentar guardar en el repositorio de project daba error por duplicidad de objetos con el mismo ID ...
porque ya lo estoy añadiendo a las listas de las entidades Empleador y Profesional
            projectRepository.save(project);


            // intento de limpiar el contexto de persistencia para evitar conflictos de entidades pero no funciona

            entityManager.flush();
            entityManager.clear();

*/
        }
    }

    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}