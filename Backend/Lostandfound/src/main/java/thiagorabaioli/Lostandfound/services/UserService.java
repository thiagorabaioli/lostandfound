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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.transaction.annotation.Transactional;

import thiagorabaioli.Lostandfound.DTO.UserAPPDTO;

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
    protected UserAPP authenticated() {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
			String username = jwtPrincipal.getClaim("username");
			return userRepository.findByEmail(username).get();
		}
		catch (Exception e) {
			throw new UsernameNotFoundException("Invalid user");
		}
	}
	
	@Transactional(readOnly = true)
	public UserAPPDTO getMe() {
		UserAPP entity = authenticated();
		return new UserAPPDTO(entity);
	}
    
}
