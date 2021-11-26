package springframework.services.map;

import org.springframework.stereotype.Service;
import springframework.model.Owner;
import springframework.services.OwnerService;
import springframework.services.PetService;
import springframework.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object == null) {
            return null;
        }

        if (object.getPets() == null) {
            return super.save(object);
        }

        object.getPets().forEach(pet -> {
            petTypeService.save(pet.getPetType());
            petService.save(pet);
        });

        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
