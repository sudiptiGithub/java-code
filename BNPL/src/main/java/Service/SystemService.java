package Service;

import Model.ProductDetail;
import Model.User;
import Repo.Inventory;
import Repo.UserDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class SystemService {

    Inventory inventory = Inventory.getINSTANCE();

    UserDao userDao = UserDao.getINSTANCE();

    public void addProductToRepo(String pName, int pQuantity, Double pPrice){
        ProductDetail productDetail = new ProductDetail(pName,pQuantity,pPrice);
        inventory.addProductInInventory(productDetail);
    }

    public void getInventory() {
        List<ProductDetail> productDetailList = inventory.getProductInventory().entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        showInventory(productDetailList);
    }

    private void showInventory(List<ProductDetail> productDetailList) {
        System.out.println("Product detail: ");
        for (ProductDetail productDetail:
             productDetailList) {
            System.out.println("name:"+ productDetail.getPName()+" price:"+productDetail.getPPrice());
        }
    }


    public void addUder(String name){
        User user = new User(name);
        userDao.addUser(user);

    }


}
