package cifo2024.losProfesionales.controller;

import cifo2024.losProfesionales.model.Professional;
import cifo2024.losProfesionales.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/")
public class ProfessionalRestController {
    @Autowired
    ProfessionalService professionalService;

    //CRUD: Read
    @RequestMapping("/professionals")
    public Iterable<Professional> getAllProfessionals(){
        return professionalService.getAllProfessionals();
    }

/*  necesito explicación ...

    @RequestMapping("/populate")
    public String populateProfessionals(){

        professionalService.populate();

        return "ok";
    }
    */
}
