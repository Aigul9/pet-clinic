package springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
