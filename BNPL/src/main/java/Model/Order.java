package Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Order {

    @Setter(AccessLevel.NONE)
    private UUID oId;

    private String orderDate;

    @Setter(AccessLevel.NONE)
    List<Items> orderItems ;

    @Setter(AccessLevel.NONE)
    private PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus;

    public Order(UUID oId, String orderDate, List<Items> orderItems, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {
        this.oId = oId;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

}
