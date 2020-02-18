package slash.process.pettingtheclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Prescription;
import slash.process.pettingtheclinic.services.PrescriptionService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PrescriptionMapService extends AbstractMapService<Prescription, Long> implements PrescriptionService {


    @Override
    public Set<Prescription> findAll() {
        return super.findAll();
    }

    @Override
    public Prescription findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Prescription save(Prescription object) {
        return super.save(object);
    }

    @Override
    public void delete(Prescription object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
