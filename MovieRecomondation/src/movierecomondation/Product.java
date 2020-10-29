/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;


public class Product {
    int id;
    String name;
    String year;
    String[] keywords;
    double rating;
    int price;

    public Product(int id, String name, String year, String[] keywords, double rating, int price) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.keywords = keywords;
        this.rating = rating;
        this.price = price;
    }
    
    
}
