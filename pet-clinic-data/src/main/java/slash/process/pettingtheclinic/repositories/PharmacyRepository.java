package slash.process.pettingtheclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import slash.process.pettingtheclinic.model.Pharmacy;

public interface PharmacyRepository extends CrudRepository<Pharmacy, Long> {
}
