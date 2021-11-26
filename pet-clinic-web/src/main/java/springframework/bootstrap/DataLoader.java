package springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.model.Owner;
import springframework.model.Pet;
import springframework.model.PetType;
import springframework.model.Specialty;
import springframework.model.Vet;
import springframework.services.OwnerService;
import springframework.services.PetTypeService;
import springframework.services.SpecialtyService;
import springframework.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) {

        if (petTypeService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        specialtyService.save(radiology);
        specialtyService.save(surgery);
        specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Owner1");
        owner1.setLastName("Owner1novich");
        owner1.setAddress("123 Brickell");
        owner1.setCity("Miami");
        owner1.setPhone("89367");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Owner2");
        owner2.setLastName("Owner2novich");
        owner2.setAddress("123 Brickell");
        owner2.setCity("Miami");
        owner2.setPhone("8967874");
        ownerService.save(owner2);

        System.out.println("----Loading owners----");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1");
        vet1.setLastName("Vet1novna");
        vet1.getSpecialties().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2");
        vet2.setLastName("Vet2novna");
        vet2.getSpecialties().add(surgery);
        vetService.save(vet2);

        System.out.println("----Loading vets----");

        Pet pet1 = new Pet();
        pet1.setName("Rosco");
        pet1.setPetType(dog);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        owner1.getPets().add(pet1);

        Pet pet2 = new Pet();
        pet2.setName("Just Cat");
        pet2.setPetType(cat);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);

        System.out.println(dog.getName());
        System.out.println(dog.getId());
    }
}
