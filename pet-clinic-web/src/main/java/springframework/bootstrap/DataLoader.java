package springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.model.Owner;
import springframework.model.Vet;
import springframework.services.OwnerService;
import springframework.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
