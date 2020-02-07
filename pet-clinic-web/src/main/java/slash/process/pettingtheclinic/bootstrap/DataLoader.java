package slash.process.pettingtheclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import slash.process.pettingtheclinic.model.*;
import slash.process.pettingtheclinic.services.*;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final CareService careService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService,
                      PetTypeService petTypeService, CareService careService, SpecialtiesService specialtiesService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.careService = careService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
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
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        //  Owner.builder().address("ASDF").build();

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.setPets(new HashSet<>());
        owner1.getPets().add(mikesPet);


        ownerService.save(owner1);
        System.out.println("Owner 1 loaded..");
        Owner owner2 = new Owner();

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Karen Street");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123");
        Pet fionnasCat = new Pet();
        fionnasCat.setName("Karena");
        fionnasCat.setOwner(owner2);
        fionnasCat.setPetType(saveCatPetType);
        fionnasCat.setBirthDate(LocalDate.now());
        owner2.setPets(new HashSet<>());
        owner2.getPets().add(fionnasCat);

        ownerService.save(owner2);
        System.out.println("Owner 2 loaded..");
        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.setSpecialties(new HashSet<>());
        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSpeciality1 = specialtiesService.save(surgery);
        vet1.getSpecialties().add(savedSpeciality1);
        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);
        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

        vetService.save(vet1);
        System.out.println("Vet 1 loaded..");
        Vet vet2 = new Vet();

        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.setSpecialties(new HashSet<>());
        vet2.getSpecialties().add(savedRadiology);
        vetService.save(vet2);
        System.out.println("Vet 2 loaded..");
        Visit visit1 = new Visit();
        visit1.setCares(new HashSet<>());
        visit1.getCares().add(idChip);
        visit1.getCares().add(vaccine);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("implementing id chip and vaccines");
        visit1.setPet(fionnasCat);
        visit1.setVet(vet1);
        visitService.save(visit1);
        System.out.println(visit1.getDescription() + " :");
        visit1.getCares().forEach(care -> {
            System.out.println(care.getType());
        });
    }
}
