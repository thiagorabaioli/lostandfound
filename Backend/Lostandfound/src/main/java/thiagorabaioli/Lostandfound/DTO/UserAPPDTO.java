package thiagorabaioli.Lostandfound.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import thiagorabaioli.Lostandfound.entities.UserAPP;


public class UserAPPDTO {


    private Long id;

    @NotBlank(message = "name not blank")
    @Size(min = 3, max = 80, message = "Name must be between 3 and 80 characters")
    private String name;

    @Email(message = "email field")
    private String email;
   

    private String porNUmber;

    private LocalDate birthDate;

    private List<String> roles = new ArrayList<>();

    public UserAPPDTO() {}

    public UserAPPDTO(Long id, String name, String email, String password, String porNUmber, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.porNUmber = porNUmber;
        this.birthDate = birthDate;

    }

    public UserAPPDTO(UserAPP entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        porNUmber = entity.getPorNUmber();
        birthDate = entity.getBirthDate();
        for (GrantedAuthority role : entity.getAuthorities()) {
			roles.add(role.getAuthority());
		}

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPorNUmber() {
        return porNUmber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getRoles() {
        return roles;
    }

}
