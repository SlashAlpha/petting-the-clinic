package slash.process.pettingtheclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import slash.process.pettingtheclinic.model.Care;

public interface CareRepository extends CrudRepository<Care, Long> {
}
