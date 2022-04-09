package Repo;

import Exceptions.ItemNotInStockException;
import Exceptions.ProductDoNotExistsException;
import Model.Items;
import Model.ProductDetail;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class Inventory {

    @Getter
    private HashMap<String, ProductDetail> productInventory = new HashMap<String, ProductDetail>();

    private static Inventory INSTANCE = null;

    public static Inventory getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new Inventory();
        }
        return INSTANCE;
    }

    public void addProductInInventory(ProductDetail productDetail){
        productInventory.put(productDetail.getPName(),productDetail);
        System.out.println("Product added in inventory :"+ productDetail.getPName());
    }

    public ProductDetail getProductDetail(String pName){
        if(productInventory.containsKey(pName)){
            return productInventory.get(pName);
        }
        else {
            throw new ProductDoNotExistsException(pName+" does not exists");
        }
    }

    public Boolean ifItemInStock(List<Items> itemsList){
        for (Items item:
             itemsList) {
            if(productInventory.containsKey(item.getPName())){
                if(productInventory.get(item.getPName()).getPQuantity()<item.getQuantity())
                    throw new ItemNotInStockException(item.getPName() +" has only "+ productInventory.get(item.getPName()).getPQuantity()+ " product in inventory");
            }
        }
        return true;
    }

}
