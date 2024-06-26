package cifo2024.losProfesionales.repository;

import cifo2024.losProfesionales.model.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends CrudRepository<Employer,String> {
}
