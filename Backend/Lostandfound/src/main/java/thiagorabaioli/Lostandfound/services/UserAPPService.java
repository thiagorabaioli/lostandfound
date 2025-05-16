package thiagorabaioli.Lostandfound.services;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import thiagorabaioli.Lostandfound.DTO.UserAPPDTO;
import thiagorabaioli.Lostandfound.entities.UserAPP;
import thiagorabaioli.Lostandfound.repositories.UserAPPRepository;
import thiagorabaioli.Lostandfound.services.exceptions.DataBaseException;
import thiagorabaioli.Lostandfound.services.exceptions.ResourceNotFoundException;


@Service
public class UserAPPService {

    @Autowired
    private UserAPPRepository repository;

    @Transactional(readOnly = true)
    public UserAPPDTO findById(Long id) {
        UserAPP entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found! "));
        return new UserAPPDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<UserAPPDTO> findAll(Pageable pageable) {
        Page<UserAPP> result = repository.findAll(pageable);
        return result.map(x-> new UserAPPDTO(x));
    }

    @Transactional
    public UserAPPDTO insert(UserAPPDTO dto) {
        UserAPP entity = new UserAPP();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new UserAPPDTO(entity);
    }
    @Transactional
    public UserAPPDTO update(Long id, UserAPPDTO dto) {
        try {
            UserAPP entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new UserAPPDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("id not found: " + id);
        }
    }

    private void copyDtoToEntity(UserAPPDTO dto, UserAPP entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPorNUmber(dto.getPorNUmber());
        entity.setBirthDate(dto.getBirthDate());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found: " + id);
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("reference integrity violation");
        }
    }

    protected UserAPP authenticated() {

        try {
           
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");
             return repository.findByEmail(username).get();
        }catch (Exception e) {
            throw new ResourceNotFoundException("User not found");
        }
        
    }
    @Transactional(readOnly = true)
	public UserAPPDTO getMe() {
		UserAPP entity = authenticated();
		return new UserAPPDTO(entity);
	}


}
