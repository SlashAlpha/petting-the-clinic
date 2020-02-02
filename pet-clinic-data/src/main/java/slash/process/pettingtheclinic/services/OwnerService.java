package slash.process.pettingtheclinic.services;

import slash.process.pettingtheclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);


}
