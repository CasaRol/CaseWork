/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Alexa
 */
public class PopularProducts {
    
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    
    

    public PopularProducts() {
        readProducts();
        readUsers();
    }
    
    public void popularProd() {
        
        System.out.println(products.get(0).name);
        System.out.println(users.get(0).name);
        
        calcCombinedScore();
        
        sortProduct();   
        
        
        //return ;
    }
    
    
    private ArrayList<Product> readProducts() {
        
        
        try (Scanner scan = new Scanner(new File("Assets/Products.txt"))) {     //Autocloseable Scanner
            while (scan.hasNextLine()) {
                String tmpLine = scan.nextLine();
                String[] part = tmpLine.split(",");

                int id = Integer.parseInt(part[0]);
                String name = part[1].substring(1);
                String year = part[2].trim();                                   //String as year shouldn't be manitpulated as an int
                String[] keywords = new String[5];
                for (int i = 0; i < 5; i++) {
                    String tmpValue = part[i+3].trim();
                    keywords[i] = tmpValue;
                }
                double rating = Double.parseDouble(part[8]);
                int price = Integer.parseInt(part[9]);

                //Create product object for this entry
                products.add(new Product(id, name, year, keywords, rating, price));
                
            }

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        
        return products;
    }
    
    private ArrayList<User> readUsers() {
        
        
        try(Scanner scan = new Scanner(new File("./Assets/users.txt"))) {
            while(scan.hasNextLine()) {
                String tmpLine = scan.nextLine();
                String[] parts = tmpLine.split(", ");
                
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                
                String[] views = parts[2].split(";");
                ArrayList<Integer> viewed = new ArrayList();                    //ArrayList as size may vary between users
                for(String part : views) {                                      
                    viewed.add(Integer.parseInt(part));                         //Parsing to int for comparason with popularProduct (Both Id's now int)
                }
                
                String[] purchase = parts[3].split(";");
                ArrayList<Integer> purchased = new ArrayList();                 //ArrayList as size may vary between users
                for(String part : purchase) {
                    purchased.add(Integer.parseInt(part));                      //Parsing to int for comparason with popularProduct (Both Id's now int)
                }

                //Create user object for this entry
                users.add(new User(id, name, viewed, purchased));
                
            }
            
        }
        catch(FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        
        return users;
    }

    private void sortProduct() {
        Collections.sort(products, new ProductComparator());
        for(Product product: products) {
            System.out.println("Movie with ID " + product.getId() + " reached a total score of " + product.getTotalScore());
        }
    }

    private void calcCombinedScore() {
        int movieSales[] = new int[41];
        
        for(User user : users) {
            for(int movie: user.getPurchased()) {
                //System.out.println("index " + movie + " is being inserted");
                movieSales[movie] += 1;
            }
        }
        
        for(int sale: movieSales) {
            //System.out.println(sale);
        }
        
        for(Product product: products) {
            product.setTotalScore(product.rating + movieSales[product.getId()]);
            //System.out.println("Total score of movie number " + product.getId() + " is " + product.getTotalScore());
        }
    }

    
    
}
