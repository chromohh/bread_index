package chromo.ec.breadindex.service;

import chromo.ec.breadindex.data.*;
import chromo.ec.breadindex.dto.UserForm;
import chromo.ec.breadindex.entity.User;
import chromo.ec.breadindex.entity.UserRole;
import chromo.ec.breadindex.entity.UserRoleEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public User registerNew(UserForm form) {
        UserRole userRole = appRoleRepository.findByRoleName(UserRoleEnums.USER).orElseThrow(
                () -> new IllegalArgumentException("Couldn't find role of " + UserRoleEnums.USER)
        );

        Set<UserRole> roleSet = new HashSet<>();
        roleSet.add(userRole);

        User newUser = new User(form.getUsername(), form.getEmail(), passwordEncoder.encode(form.getPassword()));

        newUser = userRepository.save(newUser);
        newUser.setRoleSet(roleSet);

        return newUser;
    }

    @Override
    public Optional<User> findById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return userRepository.findByEmailIgnoreCase(email);
    }
}
