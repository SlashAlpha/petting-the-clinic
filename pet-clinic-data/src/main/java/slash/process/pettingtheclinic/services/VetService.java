package slash.process.pettingtheclinic.services;

import slash.process.pettingtheclinic.model.Vet;


public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName(String lastName);


}
