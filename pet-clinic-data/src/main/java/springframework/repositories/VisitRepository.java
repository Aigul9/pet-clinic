package springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
