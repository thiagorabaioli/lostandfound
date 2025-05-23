package thiagorabaioli.Lostandfound.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import thiagorabaioli.Lostandfound.DTO.UserAPPDTO;
import thiagorabaioli.Lostandfound.services.UserAPPService;

import java.net.URI;

@RestController
@RequestMapping(value = "/usersapp")
public class UserAPPController {

    @Autowired
    private UserAPPService service;

   
    @PreAuthorize("hasAnyRole('ROLE_VIGILANTE')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserAPPDTO> findById(@PathVariable  Long id) {
        UserAPPDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);

    }

  
    
    @PreAuthorize("hasAnyRole('ROLE_OPERATOR', 'ROLE_VIGILANTE', 'ROLE_ADMIN')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserAPPDTO> getMe() {
        UserAPPDTO dto = service.getMe();
        return ResponseEntity.ok().body(dto);

    }

    @GetMapping
    public ResponseEntity<Page<UserAPPDTO>> findAll(Pageable pageable) {
        Page<UserAPPDTO> result = service.findAll(pageable);
        return ResponseEntity.ok().body(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<UserAPPDTO> insert(@Valid @RequestBody UserAPPDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserAPPDTO> update( @PathVariable  Long id, @Valid  @RequestBody UserAPPDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable  Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }


}
