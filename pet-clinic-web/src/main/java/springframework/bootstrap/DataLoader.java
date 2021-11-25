package springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.model.Owner;
import springframework.model.PetType;
import springframework.model.Vet;
import springframework.services.OwnerService;
import springframework.services.PetTypeService;
import springframework.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Owner1");
        owner1.setLastName("Owner1novich");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Owner2");
        owner2.setLastName("Owner2novich");
        ownerService.save(owner2);

        System.out.println("----Loading owners----");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1");
        vet1.setLastName("Vet1novna");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2");
        vet2.setLastName("Vet2novna");
        vetService.save(vet2);

        System.out.println("----Loading vets----");
    }
}
