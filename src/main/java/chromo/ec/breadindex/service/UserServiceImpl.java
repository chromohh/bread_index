package chromo.ec.breadindex.service;

import chromo.ec.breadindex.data.*;
import chromo.ec.breadindex.dto.UserForm;
import chromo.ec.breadindex.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private UserRoleRepo appRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepo userRepository, BCryptPasswordEncoder passwordEncoder, UserRoleRepo appRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public User save(User appUser) {
        return null;
    }

    @Override
    public User registerNew(UserForm form) {
        return null;
    }

    @Override
    public User findById(int userId) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
