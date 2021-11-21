package springframework.services;

import org.springframework.stereotype.Service;
import springframework.model.Pet;

import java.util.Set;

@Service
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
