/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecommendation;


public class Product {
    int id;
    String name;
    String year;
    String[] keywords;
    double rating;
    int price;
    double totalScore;  //Custom attribute - Used as a score for recommendation prioritization

    public Product(int id, String name, String year, String[] keywords, double rating, int price) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.keywords = keywords;
        this.rating = rating;
        this.price = price;
        this.totalScore = totalScore;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public double getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }
    
    
    
}
