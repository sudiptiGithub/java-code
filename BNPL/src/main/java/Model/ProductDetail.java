package Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetail {

    @Setter(AccessLevel.NONE)
    private String pName;

    private int pQuantity;

    private Double pPrice;

    public ProductDetail(String pName, int pQuantity, Double pPrice) {
        this.pName = pName;
        this.pQuantity = pQuantity;
        this.pPrice = pPrice;
    }

}
