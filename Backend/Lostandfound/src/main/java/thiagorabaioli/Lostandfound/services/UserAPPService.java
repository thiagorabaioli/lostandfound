package thiagorabaioli.Lostandfound.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thiagorabaioli.Lostandfound.DTO.UserAPPDTO;
import thiagorabaioli.Lostandfound.entities.UserAPP;
import thiagorabaioli.Lostandfound.repositories.UserAPPRepository;

import java.util.Optional;


@Service
public class UserAPPService {

    @Autowired
    private UserAPPRepository repository;

    @Transactional(readOnly = true)
    public UserAPPDTO findById(Long id) {
        Optional<UserAPP> result = repository.findById(id);
        UserAPP entity = result.get();
        UserAPPDTO userDTO = new UserAPPDTO(entity);
        return userDTO;
    }

    @Transactional(readOnly = true)
    public Page<UserAPPDTO> findAll(Pageable pageable) {
        Page<UserAPP> result = repository.findAll(pageable);
        return result.map(x-> new UserAPPDTO(x));
    }

    @Transactional
    public UserAPPDTO insert(UserAPPDTO dto) {
        UserAPP entity = new UserAPP();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPorNUmber(dto.getPorNUmber());
        entity.setBirthDate(dto.getBirthDate());
        entity = repository.save(entity);
        return new UserAPPDTO(entity);
    }
}
