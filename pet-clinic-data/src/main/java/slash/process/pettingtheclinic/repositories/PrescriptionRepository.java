package slash.process.pettingtheclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import slash.process.pettingtheclinic.model.Prescription;

public interface PrescriptionRepository extends CrudRepository<Prescription, Long> {

}
