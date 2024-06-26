package cifo2024.losProfesionales.repository;

import cifo2024.losProfesionales.model.Competence;
import cifo2024.losProfesionales.model.Professional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetenceRepository extends CrudRepository<Competence, String> {
//defino la búsqueda por profesional para escoger las Competencias de este en el ProjectService
    List<Competence> findByProfessional(Professional professional);

}
