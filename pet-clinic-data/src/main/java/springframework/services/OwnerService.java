package springframework.services;

import org.springframework.stereotype.Service;
import springframework.model.Owner;

import java.util.Set;

@Service
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
