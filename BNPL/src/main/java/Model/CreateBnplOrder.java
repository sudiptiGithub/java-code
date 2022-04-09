package Model;

import java.util.List;

public class CreateBnplOrder extends CreateOrder {

    public static void updateUserCredit(User user, Double orderPrice) {
        user.setUCredit(user.getUCredit() + orderPrice);
    }
}
