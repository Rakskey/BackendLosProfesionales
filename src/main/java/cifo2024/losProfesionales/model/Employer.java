package cifo2024.losProfesionales.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Employer {
    //propiedades del Usuario
    @Id
    private String id;
    private long dischargeDate;
    private String name;
    private String email;
    private String password;
    //propiedades del Empleador
    private String dniNif; // posible ID?
    private String companyName;
    private String cif;

    @OneToMany(mappedBy = "employer")
    private List <Project> projectsEmployerList = new ArrayList<>();


    //método para añadir el proyecto a la lista el proyectos de cada empleador
    public void addProject(Project project) {
        projectsEmployerList.add(project);
        project.setEmployer(this);
    }
}
