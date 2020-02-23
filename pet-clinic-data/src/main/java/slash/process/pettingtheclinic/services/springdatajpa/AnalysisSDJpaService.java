package slash.process.pettingtheclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Analysis;
import slash.process.pettingtheclinic.repositories.AnalysisRepository;
import slash.process.pettingtheclinic.services.AnalysisService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class AnalysisSDJpaService implements AnalysisService {

    AnalysisRepository analysisRepository;

    public AnalysisSDJpaService(AnalysisRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    @Override
    public Set<Analysis> findAll() {
        Set<Analysis> analysis = new HashSet<>();
        analysisRepository.findAll().forEach(analysis::add);
        return analysis;
    }

    @Override
    public Analysis findById(Long aLong) {
        return analysisRepository.findById(aLong).orElse(null);
    }

    @Override
    public Analysis save(Analysis object) {
        analysisRepository.save(object);
        return object;
    }

    @Override
    public void delete(Analysis object) {
        analysisRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        analysisRepository.deleteById(aLong);
    }
}
