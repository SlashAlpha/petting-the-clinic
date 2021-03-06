package slash.process.pettingtheclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import slash.process.pettingtheclinic.model.*;
import slash.process.pettingtheclinic.services.*;

import java.time.LocalDate;
import java.util.Date;
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
    private final PrescriptionService prescriptionService;
    private final PharmacyService pharmacyService;
    private final MedicamentService medicamentService;
    private final AnalysisService analysisService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, CareService careService, SpecialtiesService specialtiesService, VisitService visitService, PrescriptionService prescriptionService, PharmacyService pharmacyService, MedicamentService medicamentService, AnalysisService analysisService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.careService = careService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
        this.prescriptionService = prescriptionService;
        this.pharmacyService = pharmacyService;
        this.medicamentService = medicamentService;
        this.analysisService = analysisService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setAmount(0);
        pharmacy.setNumberOfMedicaments(0);
        pharmacyService.save(pharmacy);
        Medicament medicament1 = new Medicament();
        medicament1.setExpirationDate(new Date());
        medicament1.setName("blood pressure up");
        medicament1.setNumber(5);
        medicament1.setPrice(10);
        medicament1.setPharmacy(pharmacy);
        Medicament medicament1saved = medicamentService.save(medicament1);
        Medicament medicament2 = new Medicament();
        medicament2.setExpirationDate(new Date());
        medicament2.setName("blood pressure down");
        medicament2.setNumber(6);
        medicament2.setPrice(9);
        medicament2.setPharmacy(pharmacy);
        Medicament medicament2saved = medicamentService.save(medicament2);
        System.out.println("medicament saved");
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        Analysis analysis = new Analysis();
        analysis.setConclusions("the end");
        analysis.setDescription("the end");
        analysis.setType("end");
        analysisService.save(analysis);




        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Care vaccine = new Care();

        vaccine.setType("vaccine shot");
        vaccine.setHourCost(50);
        vaccine.setProductCost(20);
        vaccine.setProducts("sering,gloves,compress");
        vaccine.setTime(5);
        vaccine.setAdministrativCost(5);
        vaccine.setSpecification("Qu'est-ce que le Lorem Ipsum?\n" +
                "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depui");
        ;
        Care saveVaccineCare = careService.save(vaccine);

        Care idChip = new Care();
        idChip.setType("tatoo ID chip");
        idChip.setHourCost(50);
        idChip.setProductCost(60);
        idChip.setProducts("sering,glove, compress,chip");
        idChip.setTime(5);
        idChip.setAdministrativCost(5);
        idChip.setSpecification("Qu'est-ce que le Lorem Ipsum?\n" +
                "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depui");
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
        visit1.setDescription("implementing id chip and vaccines.Nothing unusual");
        visit1.setPet(fionnasCat);
        visit1.setVet(vet1);
        visit1.setSmallDescription("new pet package");
        Prescription prescription = new Prescription();
        prescription.setDescription("Qu'est-ce que le Lorem Ipsum?\n" +
                "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depui");
        prescriptionService.save(prescription);
        visit1.setPrescription(prescription);

        visitService.save(visit1);
        System.out.println(visit1.getDescription() + " :");
        visit1.getCares().forEach(care -> {
            System.out.println(care.getType());
        });
    }
}
