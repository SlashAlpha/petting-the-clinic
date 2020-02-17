package slash.process.pettingtheclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import slash.process.pettingtheclinic.model.Owner;
import slash.process.pettingtheclinic.model.PetType;
import slash.process.pettingtheclinic.repositories.PetRepository;
import slash.process.pettingtheclinic.services.OwnerService;
import slash.process.pettingtheclinic.services.PetService;
import slash.process.pettingtheclinic.services.PetTypeService;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetRepository pets;
    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public PetController(PetRepository pets, OwnerService ownerService, PetService petService, PetTypeService petTypeService) {
        this.pets = pets;
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

//    @InitBinder("pet")
//    public void initPetBinder(WebDataBinder dataBinder) {
//        dataBinder.setValidator(new PetValidator());
//    }

}
