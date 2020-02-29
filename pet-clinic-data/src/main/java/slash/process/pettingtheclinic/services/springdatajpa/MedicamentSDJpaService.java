package slash.process.pettingtheclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Medicament;
import slash.process.pettingtheclinic.repositories.MedicamentRepository;
import slash.process.pettingtheclinic.services.MedicamentService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class MedicamentSDJpaService implements MedicamentService {

    MedicamentRepository medicamentRepository;

    public MedicamentSDJpaService(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    @Override
    public Set<Medicament> findAll() {
        Set<Medicament> medicaments = new HashSet<>();
        medicamentRepository.findAll().forEach(medicaments::add);

        return medicaments;
    }

    @Override
    public Medicament findById(Long aLong) {
        return medicamentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Medicament save(Medicament object) {
        return medicamentRepository.save(object);
    }

    @Override
    public void delete(Medicament object) {
        medicamentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        medicamentRepository.deleteById(aLong);
    }
}
