/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alexa
 */
public class PopularProducts {
    
    ArrayList<Product> products = new ArrayList<>();

    public PopularProducts() {
    }
    
    
    public List<Product> readProducts() {
        try (Scanner scan = new Scanner(new File("Assets/Products.txt"))) {                            //Autocloseable Scanner
            while (scan.hasNextLine()) {
                String tmpLine = scan.nextLine();
                System.out.println(tmpLine);
                String[] part = tmpLine.split(",");

                int id = Integer.parseInt(part[0]);
                String name = part[1];
                String year = part[2]; //String as year shouldn't be manitpulated as an int
                String[] keywords = new String[5];
                for (int i = 0; i < 5; i++) {
                    //System.out.println("part in for-loop = " + part[i+3]);
                    String tmpValue = part[i+3].trim();
                    keywords[i] = tmpValue;
                }
                double rating = Double.parseDouble(part[8]);
                int price = Integer.parseInt(part[9]);

                Product newProduct = new Product(id, name, year, keywords, rating, price);
                products.add(newProduct);
                
                System.out.println("newProduct = " + newProduct.keywords[0]);
            }

            //System.out.println(products.get(3).toString());

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        
        return products;
    }
    
}
