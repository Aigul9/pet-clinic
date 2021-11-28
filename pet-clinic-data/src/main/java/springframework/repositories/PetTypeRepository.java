package springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.model.PetType;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
