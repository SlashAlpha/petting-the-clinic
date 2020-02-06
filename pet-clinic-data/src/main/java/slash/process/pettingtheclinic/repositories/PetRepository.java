package slash.process.pettingtheclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import slash.process.pettingtheclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
    Pet findByName(String name);
}
