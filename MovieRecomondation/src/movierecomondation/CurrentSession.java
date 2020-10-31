/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;

/**
 *
 * @author Alexa
 */
public class CurrentSession {
    
    int userID;
    int productID;

    public CurrentSession(int userID, int productID) {
        this.userID = userID;
        this.productID = productID;
    }

    public int getUserID() {
        return userID;
    }

    public int getProductID() {
        return productID;
    }
    
}
