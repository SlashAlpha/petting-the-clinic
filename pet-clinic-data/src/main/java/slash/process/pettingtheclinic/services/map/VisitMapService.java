package slash.process.pettingtheclinic.services.map;

import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Visit;
import slash.process.pettingtheclinic.services.CareService;
import slash.process.pettingtheclinic.services.PetService;
import slash.process.pettingtheclinic.services.VetService;
import slash.process.pettingtheclinic.services.VisitService;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    CareService careService;
    PetService petService;
    VetService vetService;

    public VisitMapService(CareService careService, PetService petService, VetService vetService) {
        this.careService = careService;
        this.petService = petService;
        this.vetService = vetService;
    }

    @Override
    public Visit findByTag(String tag) {
        return null;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null || object.getVet() == null || object.getPet().getId() == null
                || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("invalid visit");
        }
//        if(object!=null) {
//            if (object.getPet() != null) {
//                if (object.getPet().getId() == null) {
//                    Pet savedPet = petService.save(object.getPet());
//                    object.getPet().setId(savedPet.getId());
//                }
//            }
//            if (object.getVet() != null) {
//                if (object.getVet().getId() == null) {
//                    Vet savedVet = vetService.save(object.getVet());
//                    object.getPet().setId(savedVet.getId());
//                }
//            }
//
//
//            if (object.getCares().size() > 0) {
//                object.getCares().forEach(care -> {
//                    if (care.getId() == null) {
//                        Care savedCare = careService.save(care);
//                        care.setId(savedCare.getId());
//                    }
//                });
//            }
//        }
        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
