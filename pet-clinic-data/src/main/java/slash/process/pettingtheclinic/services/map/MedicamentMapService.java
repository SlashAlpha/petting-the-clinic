package slash.process.pettingtheclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Medicament;
import slash.process.pettingtheclinic.services.MedicamentService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class MedicamentMapService extends AbstractMapService<Medicament, Long> implements MedicamentService {

    @Override
    public Set<Medicament> findAll() {
        return super.findAll();
    }

    @Override
    public Medicament findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Medicament save(Medicament object) {
        return super.save(object);
    }

    @Override
    public void delete(Medicament object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
