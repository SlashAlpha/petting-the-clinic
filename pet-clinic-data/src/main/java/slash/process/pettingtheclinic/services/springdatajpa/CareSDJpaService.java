package slash.process.pettingtheclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Care;
import slash.process.pettingtheclinic.repositories.CareRepository;
import slash.process.pettingtheclinic.services.CareService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class CareSDJpaService implements CareService {
    CareRepository careRepository;

    public CareSDJpaService(CareRepository careRepository) {
        this.careRepository = careRepository;
    }

    @Override
    public Care findByType(String name) {
        return careRepository.findByType(name);
    }

    @Override
    public Set<Care> findAll() {
        Set<Care> cares = new HashSet<>();
        careRepository.findAll().forEach(cares::add);
        return cares;
    }

    @Override
    public Care findById(Long aLong) {
        return careRepository.findById(aLong).orElse(null);
    }

    @Override
    public Care save(Care object) {
        return careRepository.save(object);
    }

    @Override
    public void delete(Care object) {
        careRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        careRepository.deleteById(aLong);
    }
}
