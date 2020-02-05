package slash.process.pettingtheclinic.services.map;

import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Care;
import slash.process.pettingtheclinic.model.Visit;
import slash.process.pettingtheclinic.services.CareService;
import slash.process.pettingtheclinic.services.VisitService;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    CareService careService;

    public VisitMapService(CareService careService) {
        this.careService = careService;
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
        if (object.getCares().size() > 0) {
            object.getCares().forEach(care -> {
                if (care.getId() == null) {
                    Care savedCare = careService.save(care);
                    care.setId(savedCare.getId());
                }
            });
        }

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
