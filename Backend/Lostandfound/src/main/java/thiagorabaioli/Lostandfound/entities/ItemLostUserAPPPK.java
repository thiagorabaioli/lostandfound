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
}
