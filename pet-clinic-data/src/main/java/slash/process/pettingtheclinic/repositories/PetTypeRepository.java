package slash.process.pettingtheclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import slash.process.pettingtheclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
