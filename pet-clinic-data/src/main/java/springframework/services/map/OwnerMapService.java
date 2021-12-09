package springframework.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.model.Owner;
import springframework.services.OwnerService;
import springframework.services.PetService;
import springframework.services.PetTypeService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Profile("map")
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
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner == null) {
            return null;
        }

        if (owner.getPets() == null) {
            return super.save(owner);
        }

        owner.getPets().forEach(pet -> {
            petTypeService.save(pet.getPetType());
            petService.save(pet);
        });

        return super.save(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Owner is not found, lastName: " + lastName));
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        //todo - check repo
        return null;
    }
}
