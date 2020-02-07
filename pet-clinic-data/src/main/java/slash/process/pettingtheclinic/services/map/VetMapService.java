package slash.process.pettingtheclinic.services.map;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import slash.process.pettingtheclinic.model.Specialty;
import slash.process.pettingtheclinic.model.Vet;
import slash.process.pettingtheclinic.services.SpecialtiesService;
import slash.process.pettingtheclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtiesService specialtiesService;

    public VetMapService(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {

        if (vet.getSpecialties().size() > 0) {
            vet.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtiesService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
