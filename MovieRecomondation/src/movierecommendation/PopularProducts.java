/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecommendation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PopularProducts {

    ReadFromFiles rff = new ReadFromFiles();

    private ArrayList<Product> products;
    private ArrayList<User> users;

    public PopularProducts() {
        products = rff.getProducts();
        users = rff.getUsers();
    }

    public Product[] popularProd(int resultAmount) {

        calcCombinedScore();

        sortProduct();

        Product result[] = new Product[resultAmount];

        for (int i = 0; i < result.length; i++) {
            result[i] = products.get(i);
        }

        return result;
    }

    public Product[] personalRecommendation(int productID, int resultAmount) {
        Product result[] = new Product[resultAmount];

        int sales[] = amountSold();

        products = rff.getProducts();   //Clear list from previous recommendation
        String[] tags = products.get(productID - 1).getKeywords();
        List<String> checkList = Arrays.asList(tags);

        for (Product prod : products) {
            //Skip current product
            if (prod.id == productID) {
                prod.totalScore = -10; //To ensure current product to be last on the sorted list
                continue;
            }

            double recScore = 0;    //For adding up total recommendation score

            //Finding keyword matches and adding +1 per match
            for (String tag : prod.keywords) {
                if (tag.length() <= 0) {
                    continue;
                } else if (checkList.contains(tag)) {
                    recScore += 1;
                }
            }

            //Adding weight of product rating (subtract 3 from rating)
            recScore += (prod.rating - 3);

            //Adding +1 per sale to total recScore
            recScore += sales[prod.id]; //For larger systems, this should be a percentage count for less weight in recommendation

            //Add the total score to the product
            prod.setTotalScore(recScore);
        }
        
        sortProduct(); //Sorting list before returning result
        
        for (int i = 0; i < result.length; i++) {
            result[i] = products.get(i);
        }

        return result;
    }

    private void sortProduct() {
        Collections.sort(products, new ProductComparator());    //Sorting for product totalScore in decending order
    }

    private void calcCombinedScore() {

        int[] movieSales = amountSold();

        //Adding on +1 per sold unit as well as adding the rating. All in a seperate attribute for sorting later.
        for (Product product : products) {
            product.setTotalScore(product.rating + movieSales[product.getId()]);
        }
    }

    private int[] amountSold() {
        int saleCount[] = new int[41];  //41 length in order to ignore zero-indexing

        //Counting amount of movies sold. ATTENTION: Intentionally circumventing zero-indexing for the index to match movie-IDs
        for (User user : users) {
            for (int movieID : user.getPurchased()) {
                saleCount[movieID] += 1;
            }
        }

        return saleCount;
    }

}