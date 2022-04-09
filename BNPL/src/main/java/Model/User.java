package Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    @Setter(AccessLevel.NONE)
    private String uName;

    private List<Order> orderList;

    @Setter(AccessLevel.NONE)
    private Double creditLimit;

    private Double uCredit;

    public User(String uName) {
        this.uName = uName;
        this.orderList = new ArrayList<>();
        this.creditLimit = 500.0;
        this.uCredit = 0.0;
    }
}
