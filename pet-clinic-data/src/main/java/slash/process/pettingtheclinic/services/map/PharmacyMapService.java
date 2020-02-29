package slash.process.pettingtheclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Pharmacy;
import slash.process.pettingtheclinic.services.PharmacyService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PharmacyMapService extends AbstractMapService<Pharmacy, Long> implements PharmacyService {


    @Override
    public Set<Pharmacy> findAll() {
        return super.findAll();
    }

    @Override
    public Pharmacy findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Pharmacy save(Pharmacy object) {
        return super.save(object);
    }

    @Override
    public void delete(Pharmacy object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
