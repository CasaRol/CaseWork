/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;

import java.util.Comparator;

/**
 *
 * @author Alexa
 */
public class ProductComparator implements Comparator<Product>{

    public ProductComparator() {
    }

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getRating() > o2.getRating()) {
            return -1;
        } else if(o1.getRating() < o2.getRating()) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
