package thiagorabaioli.Lostandfound.entities;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user_app")
public class UserAPP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private String porNUmber;
    private String birthDate;

    @ElementCollection
    @CollectionTable(name = "phone_number")
    private Set<String> phoneNumber = new HashSet<>();

    @OneToMany(mappedBy = "id.userAPP")
    private Set<ItemLostUserAPP> items = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    
    public UserAPP() {}

    public UserAPP(Long id, String name, String email, String password, String porNUmber, String birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.porNUmber = porNUmber;
        this.birthDate = birthDate;
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
    public Set<String> getPhoneNumberSet() {
        return phoneNumber;
    }
    public void setPhoneNumberSet(Set<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Set<ItemLostUserAPP> getItems() {
        return items;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    //Return tje ItemLost associated with UserAPP
    public List<ItemLost> getItemLost(){
        return items.stream().map(x -> x.getItemLost()).toList();
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




    
}


