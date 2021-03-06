package slash.process.pettingtheclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Care;
import slash.process.pettingtheclinic.services.CareService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class CareMapService extends AbstractMapService<Care, Long> implements CareService {

    @Override
    public Care findByType(String name) {
        return null;
    }

    @Override
    public Set<Care> findAll() {
        return super.findAll();
    }

    @Override
    public Care findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Care save(Care object) {
        return super.save(object);
    }

    @Override
    public void delete(Care object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
