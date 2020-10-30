/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;

import java.util.Scanner;

public class MovieRecomondation {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to my solution for this case");
        System.out.println("Please select a number (1 or 2) for the respective part of the case followed by hitting [Enter]:");
        System.out.println("Enter 3 to exit the application");

        Scanner scan = new Scanner(System.in);                                  //Scanner opened
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1 was chosen");
                PopularProducts popProd = new PopularProducts();
                
                Product result[] = popProd.popularProd(5);                      //Change the parameter for more results returned to console
                
                System.out.println("Based on rating and purchase rate the following titles is recommended:\n");
                
                for(int i = 1; i <= result.length; i++){
                    System.out.println("Recomondation #" + i + ": " + result[i-1].getName() + " Price (USD): " + result[i-1].getPrice());
                }
                break;
            case 2:
                System.out.println("2 was chosen");
                break;
            case 3:
                System.out.println("Closing application...");
                System.exit(0);
                break;
        }

        scan.close();                                                           //Scanner closed
    }

    

}
