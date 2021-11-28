package springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.model.Vet;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
