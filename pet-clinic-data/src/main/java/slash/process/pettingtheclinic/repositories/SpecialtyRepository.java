package slash.process.pettingtheclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import slash.process.pettingtheclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
