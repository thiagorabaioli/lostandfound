package thiagorabaioli.Lostandfound.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_claimant")
public class Claimant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant instantClaimant;
    private String locale;

    @OneToOne(mappedBy = "claimant", cascade = CascadeType.ALL)
    private Delivery delivery;

    @OneToMany(mappedBy = "claimant")
    private List<ItemLost> itemLosts = new ArrayList<>();

    public Claimant() {}

    public Claimant(Long id, Instant instantClaimant, String locale, Delivery delivery) {
        this.id = id;
        this.instantClaimant = instantClaimant;
        this.locale = locale;
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstantClaimant() {
        return instantClaimant;
    }

    public void setInstantClaimant(Instant instantClaimant) {
        this.instantClaimant = instantClaimant;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<ItemLost> getItemLosts() {
        return itemLosts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Claimant claimant = (Claimant) o;
        return Objects.equals(id, claimant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
