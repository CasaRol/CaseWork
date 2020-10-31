/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadFromFiles {

    public ReadFromFiles() {
    }
    
    
    private ArrayList<Product> readProducts() {
        
        ArrayList<Product> products = new ArrayList();
        
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

                //Create product object for this file line
                products.add(new Product(id, name, year, keywords, rating, price));
                
            }

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        
        return products;
    }
    
    private ArrayList<User> readUsers() {
        
        ArrayList<User> users = new ArrayList<>();
        
        
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

                //Create user object for this file line
                users.add(new User(id, name, viewed, purchased));
                
            }
            
        }
        catch(FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        
        return users;
    }
    
    private ArrayList<CurrentSession> readSessionData() {
        
        ArrayList<CurrentSession> sessionData = new ArrayList<>();
        
        try(Scanner scan = new Scanner(new File("./Assets/CurrentUserSession.txt"))) {
            while(scan.hasNextLine()) {
                String tmpLine = scan.nextLine();
                
                String[] parts = tmpLine.split(", ");
                
                int userID = Integer.parseInt(parts[0].trim());
                int productID = Integer.parseInt(parts[1].trim());
                
                //Create user object for this file line
                CurrentSession newData = new CurrentSession(userID, productID);
                sessionData.add(newData);
                
            }
            
        }
        catch(FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        
        return sessionData;
        
    }
    
    
    public ArrayList<User> getUsers() {
        return readUsers();
    }
    
    public ArrayList<Product> getProducts() {
        return readProducts();
    }
    
    public ArrayList<CurrentSession> getSessionData() {
        return readSessionData();
    }
    
}
