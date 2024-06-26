package cifo2024.losProfesionales.controller;

import cifo2024.losProfesionales.model.Employer;
import cifo2024.losProfesionales.model.Project;
import cifo2024.losProfesionales.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/projects")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/allprojects")
    public Iterable<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping("/populate/{numberOfProjects}")
    public ResponseEntity<String> populateProjects(@PathVariable int numberOfProjects) {
        try {
            projectService.populateProjects(numberOfProjects);
            return ResponseEntity.ok("Población de " + numberOfProjects + " proyectos realizada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al poblar proyectos: " + e.getMessage());
        }
    }

    // Método sin parámetro para poblar 3 proyectos por defecto
    @PostMapping("/populate")
    public ResponseEntity<String> populateDefaultProjects() {
        int defaultNumberOfProjects = 3;
        try {
            projectService.populateProjects(defaultNumberOfProjects);
            return ResponseEntity.ok("Población de " + defaultNumberOfProjects + " proyectos realizada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al poblar proyectos: " + e.getMessage());
        }
    }
}

