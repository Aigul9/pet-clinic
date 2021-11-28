package springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.model.Specialty;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
