package slash.process.pettingtheclinic.services;

import slash.process.pettingtheclinic.model.Pet;

import java.util.Set;

public interface PetService {


    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
