package slash.process.pettingtheclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import slash.process.pettingtheclinic.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);

}
