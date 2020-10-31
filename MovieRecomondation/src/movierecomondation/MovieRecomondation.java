/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieRecomondation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to my solution for this case");

        while (true) {
            System.out.println("Please select a number (1 or 2) for the respective part of the case followed by hitting [Enter]:");
            System.out.println("Enter 3 to exit the application");

            Scanner scan = new Scanner(System.in);                                  //Scanner opened
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    PopularProducts popProd = new PopularProducts();

                    Product[] resultPart1 = popProd.popularProd(5);                 //Change the parameter for more results returned to console (1-40 range)

                    System.out.println("Based on rating and purchase rate the following titles are recommended:\n");

                    for (int i = 1; i <= resultPart1.length; i++) {
                        System.out.println("Recomondation #" + i + ": " + resultPart1[i - 1].getName() + " - Price: $" + resultPart1[i - 1].getPrice());
                    }
                    
                    System.out.println("________________________________________"); //Seperation between results
                    break;
                case 2:

                    PopularProducts userRec = new PopularProducts();
                    ReadFromFiles rff = new ReadFromFiles();

                    ArrayList<User> users = rff.getUsers();

                    ArrayList<CurrentSession> sessionData = rff.getSessionData();

                    for (CurrentSession data : sessionData) {
                        Product[] resultPart2 = userRec.personalRecommondation(data.productID, 5);  //Change number in parameter for custom amount of results (1-40)

                        System.out.println("Hello " + users.get(data.userID - 1).getName() + "! You might also like these movies: ");
                        for (Product prod : resultPart2) {
                            System.out.println("\"" + prod.getName() + "\" " + prod.getYear() + " Rating: " + prod.getRating() + " - Only $" + prod.getPrice());
                        }
                        
                        System.out.println("________________________________________"); //Seperation between users results
                    }

                    break;
                case 3:
                    System.out.println("Closing application...");
                    System.exit(0);
                    break;
            }

            choice = 0;
        }

    }

}
