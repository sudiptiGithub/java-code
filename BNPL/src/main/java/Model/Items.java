package Model;

import lombok.Getter;

@Getter
public class Items {

    String pName;

    int quantity;

    public Items(String pName, int quantity) {
        this.pName = pName;
        this.quantity = quantity;
    }
}
