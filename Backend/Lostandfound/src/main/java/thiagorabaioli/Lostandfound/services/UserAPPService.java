package thiagorabaioli.Lostandfound.services;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thiagorabaioli.Lostandfound.DTO.UserAPPDTO;
import thiagorabaioli.Lostandfound.entities.UserAPP;
import thiagorabaioli.Lostandfound.repositories.UserAPPRepository;
import thiagorabaioli.Lostandfound.services.exceptions.ResourceNotFoundException;

import java.util.Optional;


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
        UserAPP entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new UserAPPDTO(entity);
    }

    private void copyDtoToEntity(UserAPPDTO dto, UserAPP entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPorNUmber(dto.getPorNUmber());
        entity.setBirthDate(dto.getBirthDate());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
