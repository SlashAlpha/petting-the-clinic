package slash.process.pettingtheclinic.controllers;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import slash.process.pettingtheclinic.model.Pet;
import slash.process.pettingtheclinic.model.Vet;
import slash.process.pettingtheclinic.model.Visit;
import slash.process.pettingtheclinic.services.PetService;
import slash.process.pettingtheclinic.services.VetService;
import slash.process.pettingtheclinic.services.VisitService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Controller
public class VisitController {

    private final VisitService visitService;

    private final PetService petService;
    private final VetService vetService;

    public VisitController(VisitService visitService, PetService petService, VetService vetService) {
        this.visitService = visitService;
        this.petService = petService;
        this.vetService = vetService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {

        dataBinder.setDisallowedFields("id");
        dataBinder.registerCustomEditor(LocalDate.class, new PropertiesEditor() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }

    @ModelAttribute("vets")
    public Collection<Vet> populateVet() {
        return vetService.findAll();
    }

    /**
     * Called before each and every @RequestMapping annotated method. 2 goals: - Make sure
     * we always have fresh data - Since we do not use the session scope, make sure that
     * Pet object always has an id (Even though id is not part of the form fields)
     *
     * @param petId
     * @return Pet
     */
    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Map<String, Object> model) {
        Pet pet = this.petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId, Map<String, Object> model) {

        return "pets/createOrUpdateVisitForm";
    }

    // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result, Vet vet) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visit.setVet(vet);
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }

    @GetMapping("/owners/*/pets/{petId}/visits/{visitId}")
    public String showVisit(@PathVariable Long visitId, Model model) {
        model.addAttribute("visit", visitService.findById(visitId));
        return "visits/showVisit";
    }

    @GetMapping("/api/visits")
    public @ResponseBody
    Set<Visit> getVisitsJson() {
        return visitService.findAll();

    }

}
