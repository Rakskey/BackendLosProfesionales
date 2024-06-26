package cifo2024.losProfesionales.model;

import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Professional {
    //propiedades del Usuario
    @Id
    private String id;
    private long dischargeDate;
    private String name;
    private String email;
    private String password;
    //propiedades de profesional
    private String dniNif; // posible ID?
    private String companyName;
    //Relación one to many con sus competencias/servicios disponibles a contratar
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL)
    //Creamos la array list de Competencias que tendrá cada profesional
    private  List <Competence> professionalCompetencesList= new ArrayList<>();
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL)
    private  List <Project> professionalProjectsList= new ArrayList<>();


//--  Métodos de la clase
    public void addCompetence(Competence competence) {
        this.getProfessionalCompetencesList().add(competence);
        //seteamos el null inicial de la creación de la competencia
        competence.setProfessional(this);
    }

    public void addProject(Project project) {
        this.getProfessionalProjectsList().add(project);
        project.setProfessional(this);
    }


}
