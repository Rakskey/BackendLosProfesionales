package cifo2024.losProfesionales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Competence {
    @Id
    private String id;
    private long creationTime;
    private String competenceTitle;
    @Column(columnDefinition = "TEXT") // https://www.baeldung.com/jpa-annotation-postgresql-text-type
    private String competenceDescription;
    private String typeOfCompetence;
    private Boolean competenceStatus;
   // relación many to one  con Profesional
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PROFESSIONAL_ID")
    private Professional professional;


}
