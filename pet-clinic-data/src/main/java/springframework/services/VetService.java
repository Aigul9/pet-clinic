package springframework.services;

import org.springframework.stereotype.Service;
import springframework.model.Vet;

import java.util.Set;

@Service
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
