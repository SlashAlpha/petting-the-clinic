package slash.process.pettingtheclinic.services;

import slash.process.pettingtheclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String name);


}
