package chromo.ec.breadindex.service;

import chromo.ec.breadindex.dto.UserForm;
import chromo.ec.breadindex.entity.User;

public interface UserService {
    User save(User appUser);
    User registerNew(UserForm form);
}
