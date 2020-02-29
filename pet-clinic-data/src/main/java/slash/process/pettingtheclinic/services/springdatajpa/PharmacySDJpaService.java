package slash.process.pettingtheclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Pharmacy;
import slash.process.pettingtheclinic.repositories.PharmacyRepository;
import slash.process.pettingtheclinic.services.PharmacyService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PharmacySDJpaService implements PharmacyService {
    PharmacyRepository pharmacyRepository;

    public PharmacySDJpaService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public Set<Pharmacy> findAll() {
        Set<Pharmacy> pharmacies = new HashSet<>();
        pharmacyRepository.findAll().forEach(pharmacies::add);
        return pharmacies;
    }

    @Override
    public Pharmacy findById(Long aLong) {
        return pharmacyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pharmacy save(Pharmacy object) {
        return pharmacyRepository.save(object);
    }

    @Override
    public void delete(Pharmacy object) {
        pharmacyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        pharmacyRepository.deleteById(aLong);
    }
}
