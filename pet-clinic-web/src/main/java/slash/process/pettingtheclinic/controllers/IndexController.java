package slash.process.pettingtheclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import slash.process.pettingtheclinic.model.Pet;
import slash.process.pettingtheclinic.services.CareService;
import slash.process.pettingtheclinic.services.PetService;
import slash.process.pettingtheclinic.services.PrescriptionService;
import slash.process.pettingtheclinic.services.VisitService;

import java.util.Set;

@Controller
public class IndexController {


    VisitService visitService;
    CareService careService;
    PrescriptionService prescriptionService;
    PetService petService;

    public IndexController(VisitService visitService, CareService careService, PrescriptionService prescriptionService, PetService petService) {
        this.visitService = visitService;
        this.careService = careService;
        this.prescriptionService = prescriptionService;
        this.petService = petService;
    }

    @RequestMapping({"/", "", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/oups")
    public String error() {
        return "notImplemented";
    }

    @RequestMapping("/index/stats")
    public String showStats(Model model) {
        model.addAttribute("visits", visitService.findAll());
        model.addAttribute("cares", careService.findAll());
        model.addAttribute("prescriptions", prescriptionService.findAll());

        return "stats";
    }

    @GetMapping("/api/pets")
    public @ResponseBody
    Set<Pet> getVetsJson() {
        return petService.findAll();

    }
}
