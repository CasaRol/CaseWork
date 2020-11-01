/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecommendation;

import java.util.ArrayList;


public class User {
    int id;
    String name;
    ArrayList<Integer> viewed;
    ArrayList<Integer> purchased;

    public User(int id, String name, ArrayList<Integer> viewed, ArrayList<Integer> purchased) {
        this.id = id;
        this.name = name;
        this.viewed = viewed;
        this.purchased = purchased;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public ArrayList<Integer> getViewed() {
        return viewed;
    }

    public ArrayList<Integer> getPurchased() {
        return purchased;
    }

    
    
    
    
    
    
}
