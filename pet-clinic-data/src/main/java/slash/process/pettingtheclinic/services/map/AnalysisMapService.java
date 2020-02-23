package slash.process.pettingtheclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Analysis;
import slash.process.pettingtheclinic.services.AnalysisService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class AnalysisMapService extends AbstractMapService<Analysis, Long> implements AnalysisService {


    @Override
    public Set<Analysis> findAll() {
        return super.findAll();
    }

    @Override
    public Analysis findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Analysis save(Analysis object) {
        return super.save(object);
    }

    @Override
    public void delete(Analysis object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
