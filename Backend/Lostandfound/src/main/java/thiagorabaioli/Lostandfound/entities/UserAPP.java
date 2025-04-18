package thiagorabaioli.Lostandfound.entities;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAPP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String porNUmber;

    @ElementCollection
    @CollectionTable(name = "phone_number")
    private Set<String> phoneNumber = new HashSet<>();
    
    public UserAPP() {}

    public UserAPP(Long id, String name, String email, String password, String porNUmber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.porNUmber = porNUmber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPorNUmber() {
        return porNUmber;
    }

    public void setPorNUmber(String porNUmber) {
        this.porNUmber = porNUmber;
    }
    public Set<String> getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Set<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumber.add(phoneNumber);
    }
    public void removePhoneNumber(String phoneNumber) {
        this.phoneNumber.remove(phoneNumber);
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserAPP other = (UserAPP) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Set<String> getPhoneNumberSet() {
        return phoneNumber;
    }

    public void setPhoneNumberSet(Set<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    
}


