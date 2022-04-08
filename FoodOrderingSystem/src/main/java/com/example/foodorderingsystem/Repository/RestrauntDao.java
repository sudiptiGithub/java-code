package com.example.foodorderingsystem.Repository;

import com.example.foodorderingsystem.Model.Restraunt;
import com.example.foodorderingsystem.Service.RestrauntService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestrauntDao {

    List<Restraunt> restrauntList = new ArrayList<>();

    private static RestrauntDao INSTANCE = null;

    public static RestrauntDao getRestrauntDao(){
        if(INSTANCE == null){
            INSTANCE =  new RestrauntDao();
        }
        return INSTANCE;
    }

    public List<Restraunt> getRestrauntList() {
        return restrauntList;
    }
}
