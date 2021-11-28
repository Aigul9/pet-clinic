package springframework.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.model.Visit;
import springframework.repositories.VisitRepository;
import springframework.services.VisitService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@Profile({"default", "jpa"})
public class VisitJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        Optional<Visit> optionalVisit = visitRepository.findById(id);
        return optionalVisit.orElseThrow(() -> new NoSuchElementException("Visit is not found, id: " + id));
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
