package thiagorabaioli.Lostandfound.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_lost_user_app")
public class ItemLostUserAPP {

    @EmbeddedId
    private ItemLostUserAPPPK id = new ItemLostUserAPPPK();

   public ItemLostUserAPP(){}

public ItemLostUserAPP(ItemLost lost, UserAPP userd){
        id.setItemLost(lost);
        id.setUserAPP(userd);

   }

    public ItemLostUserAPPPK getId() {
        return id;
    }

    public UserAPP getUserAPP() {
       return id.getUserAPP();
    }
    public void setUserAPP(UserAPP userd) {
       id.setUserAPP(userd);
    }


    public ItemLost getItemLost() {
       return id.getItemLost();
    }

    public void setItemLost(ItemLost itemLost) {
       id.setItemLost(itemLost);
    }
}
