package thiagorabaioli.Lostandfound.entities;

import jakarta.persistence.*;
import thiagorabaioli.Lostandfound.entities.enums.TYPEOFLOST;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_item_lost")
public class ItemLost {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Instant instantItemLost;
        private boolean status;
        private Integer type;
        private String location;
        private String whoFind;

        @Column(columnDefinition = "TEXT")
        private String description;
        private LocalDate dataFound;
        private String imgUrl;

        @ManyToOne
        @JoinColumn(name = "claimant_id")
        private Claimant claimant;

        @OneToMany(mappedBy = "id.itemLost")
        private Set<ItemLostUserAPP> items = new HashSet<>();


    public ItemLost() {}

    public ItemLost(Long id, Instant instantItemLost, boolean status, TYPEOFLOST type, String location, String whoFind, String description, LocalDate dataFound, String imgUrl, Claimant claimant) {
        this.id = id;
        this.instantItemLost = instantItemLost;
        this.status = status;
        this.type = type.getCod();
        this.location = location;
        this.whoFind = whoFind;
        this.description = description;
        this.dataFound = dataFound;
        this.imgUrl = imgUrl;
        this.claimant = claimant;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDate getDataFound() {
        return dataFound;
    }

    public void setDataFound(LocalDate dataFound) {
        this.dataFound = dataFound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhoFind() {
        return whoFind;
    }

    public void setWhoFind(String whoFind) {
        this.whoFind = whoFind;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TYPEOFLOST getType() {
        return TYPEOFLOST.toEnum(type);
    }

    public void setType(TYPEOFLOST type) {
        this.type = type.getCod();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Instant getInstantItemLost() {
        return instantItemLost;
    }

    public void setInstantItemLost(Instant instantItemLost) {
        this.instantItemLost = instantItemLost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Claimant getClaimant() {
        return claimant;
    }

    public void setClaimant(Claimant claimant) {
        this.claimant = claimant;
    }

    public Set<ItemLostUserAPP> getItems() {
        return items;
    }

    //Return UserAPP associated with de ItemLost
    public List<UserAPP> getUserAPP(){
        return items.stream().map(x -> x.getUserAPP()).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemLost itemLost = (ItemLost) o;
        return Objects.equals(id, itemLost.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

