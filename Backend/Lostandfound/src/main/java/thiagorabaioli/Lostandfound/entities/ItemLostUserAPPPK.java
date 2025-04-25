package thiagorabaioli.Lostandfound.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemLostUserAPPPK {

    @ManyToOne
    @JoinColumn(name = "item_lost_id")
    private ItemLost itemLost;

    @ManyToOne
    @JoinColumn(name = "user_app_id")
    private UserAPP userAPP;

    public ItemLostUserAPPPK () {}

    public ItemLost getItemLost() {
        return itemLost;
    }

    public void setItemLost(ItemLost itemLost) {
        this.itemLost = itemLost;
    }

    public UserAPP getUserAPP() {
        return userAPP;
    }

    public void setUserAPP(UserAPP userAPP) {
        this.userAPP = userAPP;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemLost == null) ? 0 : itemLost.hashCode());
        result = prime * result + ((userAPP == null) ? 0 : userAPP.hashCode());
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
        ItemLostUserAPPPK other = (ItemLostUserAPPPK) obj;
        if (itemLost == null) {
            if (other.itemLost != null)
                return false;
        } else if (!itemLost.equals(other.itemLost))
            return false;
        if (userAPP == null) {
            if (other.userAPP != null)
                return false;
        } else if (!userAPP.equals(other.userAPP))
            return false;
        return true;
    }

    
}
