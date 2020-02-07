package slash.process.pettingtheclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import slash.process.pettingtheclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    Visit findByTag(String tag);

}
