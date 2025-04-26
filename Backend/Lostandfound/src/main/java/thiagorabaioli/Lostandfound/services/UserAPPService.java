package thiagorabaioli.Lostandfound.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thiagorabaioli.Lostandfound.DTO.UserAPPDTO;
import thiagorabaioli.Lostandfound.entities.UserAPP;
import thiagorabaioli.Lostandfound.repositories.UserAPPRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<UserAPPDTO> findAll(){
        List<UserAPP> result = repository.findAll();
        List<UserAPPDTO> userDTOs = new ArrayList<>();
        return result.stream().map(x -> new UserAPPDTO(x)).collect(Collectors.toList());
    }
}
