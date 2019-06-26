package com.carapp.carscrapordermanager;

import com.carapp.carscrapordermanager.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<User> list = new ArrayList<User>();

        User user = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        for(User u:list){
            System.out.println(u);
            list.remove(u);
            list.add(u);
        }
    }
}
