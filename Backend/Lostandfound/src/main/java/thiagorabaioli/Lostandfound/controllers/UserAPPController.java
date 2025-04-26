package thiagorabaioli.Lostandfound.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thiagorabaioli.Lostandfound.DTO.UserAPPDTO;
import thiagorabaioli.Lostandfound.services.UserAPPService;

import java.util.List;

@RestController
@RequestMapping(value = "/usersapp")
public class UserAPPController {

    @Autowired
    private UserAPPService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserAPPDTO> findById(@PathVariable  Long id) {
        UserAPPDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);

    }

    @GetMapping
    public ResponseEntity<Page<UserAPPDTO>> findAll(Pageable pageable) {
        Page<UserAPPDTO> result = service.findAll(pageable);
        return ResponseEntity.ok().body(result);
    }
}
