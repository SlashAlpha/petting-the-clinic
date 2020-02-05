package slash.process.pettingtheclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import slash.process.pettingtheclinic.model.Care;
import slash.process.pettingtheclinic.model.Owner;
import slash.process.pettingtheclinic.model.PetType;
import slash.process.pettingtheclinic.model.Vet;
import slash.process.pettingtheclinic.services.*;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final CareService careService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService,
                      PetTypeService petTypeService, CareService careService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.careService = careService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Care vaccine = new Care();
        vaccine.setType("vaccine shot");
        vaccine.setHourCost(50);
        vaccine.setProductCost(20);
        vaccine.setProducts("sering,gloves,compress");
        vaccine.setTime(5);
        vaccine.setAdministrationCost(5);
        Care saveVaccineCare = careService.save(vaccine);

        Care idChip = new Care();
        idChip.setType("tatoo ID chip");
        idChip.setHourCost(50);
        idChip.setProductCost(60);
        idChip.setProducts("sering,glove compress");
        idChip.setTime(5);
        idChip.setAdministrationCost(5);
        Care saveidChipCare = careService.save(idChip);


        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);
        System.out.println("Owner 1 loaded..");
        Owner owner2 = new Owner();

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        ownerService.save(owner2);
        System.out.println("Owner 2 loaded..");
        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);
        System.out.println("Vet 1 loaded..");
        Vet vet2 = new Vet();

        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);
        System.out.println("Vet 2 loaded..");
    }
}
