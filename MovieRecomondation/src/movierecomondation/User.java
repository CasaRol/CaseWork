/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;


public class User {
    int name;
    int[] viewed;
    int[] purchased;

    public User(int name, int[] viewed, int[] purchased) {
        this.name = name;
        this.viewed = viewed;
        this.purchased = purchased;
    }
    
    
}
