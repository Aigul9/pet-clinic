package springframework.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.model.Specialty;
import springframework.repositories.SpecialtyRepository;
import springframework.services.SpecialtyService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpa")
public class SpecialtyJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        Optional<Specialty> optionalSpecialty = specialtyRepository.findById(id);
        return optionalSpecialty.orElseThrow(() -> new NoSuchElementException("Specialty is not found, id: " + id));
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
