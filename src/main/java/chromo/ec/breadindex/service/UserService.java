package chromo.ec.breadindex.service;

import chromo.ec.breadindex.dto.UserForm;
import chromo.ec.breadindex.entity.User;

import java.util.Optional;

public interface UserService {
    User save(User appUser);
    User registerNew(UserForm form);
    User findById(int userId);
    Optional<User> findByEmail(String email);
}
