package thiagorabaioli.Lostandfound.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import thiagorabaioli.Lostandfound.entities.Role;
import thiagorabaioli.Lostandfound.entities.UserAPP;
import thiagorabaioli.Lostandfound.projections.UserDetailsProjection;
import thiagorabaioli.Lostandfound.repositories.UserAPPRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserAPPRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = userRepository.searchUserAndRolesByEmail(username);
        if(result.size() == 0) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        UserAPP userApp = new UserAPP();
        userApp.setEmail(username);
        userApp.setPassword(result.get(0).getPassword());
        for (UserDetailsProjection projection : result) {
            userApp.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }
        return userApp;
    }
}
