package cifo2024.losProfesionales.controller;

import cifo2024.losProfesionales.model.Competence;
import cifo2024.losProfesionales.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/")
public class CompetenceRestController {
    @Autowired
    CompetenceService competenceService;

    //CRUD: Read
    @RequestMapping("/competences")
    public Iterable<Competence> getAllCompetences(){
        return competenceService.getAllCompetences();
    }

    @RequestMapping("/competence")
    public String getCompetenceById(@RequestParam String id){
        Optional<Competence> competenceFound = competenceService.getCompetenceById(id);
        String response = "";
        if(competenceFound.isPresent()){
            response = "el servicio con ID" + id + " es: \n" + competenceFound.get().getCompetenceTitle() +
            "\n \ny su descripción es: \n"+ competenceFound.get().getCompetenceDescription();
            return response;
        }else{
            return "No se ha encontrado el servicio con el ID:" + id;
        }

    }
}
