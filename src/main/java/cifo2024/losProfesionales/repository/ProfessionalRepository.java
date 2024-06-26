package cifo2024.losProfesionales.repository;

import org.springframework.data.repository.CrudRepository;
import cifo2024.losProfesionales.model.Professional;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professional, String>{ }
