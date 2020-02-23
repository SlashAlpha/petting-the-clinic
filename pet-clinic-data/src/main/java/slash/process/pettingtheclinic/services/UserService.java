package slash.process.pettingtheclinic.services;

import slash.process.pettingtheclinic.model.User;

public interface UserService {

    User save(User user);


   User findByUserName(String nickname);
}
