package springframework.services.map;

import org.springframework.stereotype.Service;
import springframework.model.Pet;
import springframework.services.PetService;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        if (object.getId() == null) {
            return super.save(object);
        } else {
            return object;
        }
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
