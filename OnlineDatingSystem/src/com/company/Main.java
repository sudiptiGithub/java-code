package com.company;

import com.company.Model.Gender;
import com.company.Service.SystemService;

public class Main {

    public static void main(String[] args) {
	// write your code here

        SystemService systemService = new SystemService();

        systemService.add_user("Priyanka","2,3","sleep,eat,dance", Gender.FEMALE,30);

        systemService.add_user("Rohit","2,4","sleep,eat,run", Gender.MALE,30);
        systemService.add_user("Raunak","2,3","sleep,eat,run", Gender.MALE,30);
        systemService.add_user("Kiran","5,4","sleep,read,run", Gender.FEMALE,36);
        systemService.add_user("Ki","5,4","sleep,read,run", Gender.FEMALE,36);

        systemService.getMatches("Rohit");

        systemService.userLike("Rohit","Kiran");
        systemService.userLike("Kiran","Rohit");
        //systemService.userLike("Rohit","Ki");
        //systemService.userLike("Rohit","Ki");
        //systemService.does_user_like("Kiran","Rohit");

        systemService.matches();

        // display user with opposite gender, similar integerest, close location

        //show all users who liked each other
    }
}
