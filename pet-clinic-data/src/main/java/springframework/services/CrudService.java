package springframework.services;

import java.util.Set;

// mimicking Spring Data Repo
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save (T object);

    void delete (T object);

    void deleteById(ID id);
}
