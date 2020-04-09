package chromo.ec.breadindex.service;

import chromo.ec.breadindex.data.UserRepo;
import chromo.ec.breadindex.entity.User;
import chromo.ec.breadindex.entity.*;
import chromo.ec.breadindex.security.BreadUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailService implements UserDetailsService {
    private UserRepo userRepository;

    @Autowired
    public UserDetailService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmailIgnoreCase(email);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Collection<GrantedAuthority> collection = new HashSet<>();
            for(UserRole role : user.getRoleSet()){
                collection.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            return new BreadUserDetails(user, collection);
        }else{
            throw new UsernameNotFoundException("Couldn't find user with email " + email);
        }
    }
}