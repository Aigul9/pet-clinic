package springframework.services.map;

import org.springframework.stereotype.Service;
import springframework.model.PetType;
import springframework.services.PetTypeService;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        if (object != null) {
            if (object.getId() == null) {
                return super.save(object);
            } else {
                return object;
            }
        } else {
            throw new RuntimeException("Pet Type is required");
        }
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
