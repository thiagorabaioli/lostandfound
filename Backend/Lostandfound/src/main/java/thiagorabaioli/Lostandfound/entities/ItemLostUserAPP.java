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
      ItemLostUserAPP other = (ItemLostUserAPP) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      return true;
    }
    
}
