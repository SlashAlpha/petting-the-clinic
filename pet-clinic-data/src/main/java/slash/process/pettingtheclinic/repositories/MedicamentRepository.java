package slash.process.pettingtheclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import slash.process.pettingtheclinic.model.Medicament;

public interface MedicamentRepository extends CrudRepository<Medicament, Long> {
}
