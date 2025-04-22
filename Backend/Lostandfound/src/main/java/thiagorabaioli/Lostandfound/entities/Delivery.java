package thiagorabaioli.Lostandfound.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant instantDelivery;

    @OneToOne
    @MapsId
    private Claimant claimant;

    public Delivery(Instant instantDelivery, Claimant claimant, Long id) {
        this.instantDelivery = instantDelivery;
        this.claimant = claimant;
        this.id = id;
    }

    public Delivery(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstantDelivery() {
        return instantDelivery;
    }

    public void setInstantDelivery(Instant instantDelivery) {
        this.instantDelivery = instantDelivery;
    }

    public Claimant getClaimant() {
        return claimant;
    }

    public void setClaimant(Claimant claimant) {
        this.claimant = claimant;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
