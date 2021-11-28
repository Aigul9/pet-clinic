package springframework.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.model.Vet;
import springframework.repositories.VetRepository;
import springframework.services.VetService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@Profile({"default", "jpa"})
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        Optional<Vet> optionalVet = vetRepository.findById(id);
        return optionalVet.orElseThrow(() -> new NoSuchElementException("Vet is not found, id: " + id));
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
