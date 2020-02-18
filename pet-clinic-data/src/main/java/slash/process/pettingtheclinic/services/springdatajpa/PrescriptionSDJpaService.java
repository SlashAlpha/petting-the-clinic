package slash.process.pettingtheclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Prescription;
import slash.process.pettingtheclinic.repositories.PrescriptionRepository;
import slash.process.pettingtheclinic.services.PrescriptionService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PrescriptionSDJpaService implements PrescriptionService {
    PrescriptionRepository prescriptionRepository;

    public PrescriptionSDJpaService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Set<Prescription> findAll() {
        Set<Prescription> prescriptions = new HashSet<>();
        prescriptionRepository.findAll().forEach(prescriptions::add);
        return prescriptions;
    }

    @Override
    public Prescription findById(Long aLong) {

        return prescriptionRepository.findById(aLong).orElse(null);

    }

    @Override
    public Prescription save(Prescription object) {
        return prescriptionRepository.save(object);
    }

    @Override
    public void delete(Prescription object) {
        prescriptionRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        prescriptionRepository.deleteById(aLong);
    }
}
