package springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
