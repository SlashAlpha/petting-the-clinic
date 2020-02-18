package slash.process.pettingtheclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import slash.process.pettingtheclinic.services.CareService;
import slash.process.pettingtheclinic.services.PrescriptionService;
import slash.process.pettingtheclinic.services.VisitService;

@Controller
public class IndexController {

    VisitService visitService;
    CareService careService;
    PrescriptionService prescriptionService;

    public IndexController(VisitService visitService, CareService careService, PrescriptionService prescriptionService) {
        this.visitService = visitService;
        this.careService = careService;
        this.prescriptionService = prescriptionService;
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
}
