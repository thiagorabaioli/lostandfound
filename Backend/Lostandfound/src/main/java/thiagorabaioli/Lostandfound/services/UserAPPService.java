package thiagorabaioli.Lostandfound.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thiagorabaioli.Lostandfound.DTO.UserAPPDTO;
import thiagorabaioli.Lostandfound.entities.UserAPP;
import thiagorabaioli.Lostandfound.repositories.UserAPPRepository;

import java.util.Optional;

@Service
public class UserAPPService {

    @Autowired
    private UserAPPRepository repository;

    public UserAPPDTO findById(Long id) {
        Optional<UserAPP> result = repository.findById(id);
        UserAPP entity = result.get();
        UserAPPDTO userDTO = new UserAPPDTO(entity);
        return userDTO;
    }
}
