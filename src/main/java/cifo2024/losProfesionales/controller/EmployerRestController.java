package cifo2024.losProfesionales.controller;

import cifo2024.losProfesionales.model.Employer;
import cifo2024.losProfesionales.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/")
public class EmployerRestController {

    @Autowired
    EmployerService employerService;

    //CRUD: Create
    @PostMapping("/new")

    //CRUD: Read
    @RequestMapping("/employers")
    public Iterable<Employer> getAllEmployers(){
        return employerService.getAllEmployers();
    }

    @RequestMapping("/populate")
    public String populateEmployer(){

        employerService.populate();

        return "ok";
    }
}
