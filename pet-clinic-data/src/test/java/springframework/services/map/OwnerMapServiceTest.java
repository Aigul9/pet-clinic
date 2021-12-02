package springframework.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframework.model.Owner;

import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ID = 1L;
    final String LAST_NAME = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ID).lastName(LAST_NAME).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ID);
        assertEquals(ID, owner.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ID);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ID));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        long id2 = 2L;
        Owner owner2 = Owner.builder().id(id2).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id2, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(LAST_NAME);
        assertNotNull(owner);
        assertEquals(ID, owner.getId());
        assertEquals(LAST_NAME, owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        assertThrows(NoSuchElementException.class, () -> ownerMapService.findByLastName("foo"));
    }
}