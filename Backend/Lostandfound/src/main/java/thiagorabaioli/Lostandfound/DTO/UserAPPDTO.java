package thiagorabaioli.Lostandfound.DTO;

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
    private String password;

    private String porNUmber;

    private String birthDate;

    public UserAPPDTO() {}

    public UserAPPDTO(Long id, String name, String email, String password, String porNUmber, String birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.porNUmber = porNUmber;
        this.birthDate = birthDate;

    }

    public UserAPPDTO(UserAPP entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        password = entity.getPassword();
        porNUmber = entity.getPorNUmber();
        birthDate = entity.getBirthDate();

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

    public String getPassword() {
        return password;
    }

    public String getPorNUmber() {
        return porNUmber;
    }

    public String getBirthDate() {
        return birthDate;
    }

}
