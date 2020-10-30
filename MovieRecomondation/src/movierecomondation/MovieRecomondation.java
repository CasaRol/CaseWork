/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecomondation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MovieRecomondation {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to my solution for the provided case");
        System.out.println("Please select a number (1 or 2) for the respective part of the case followed by hitting [Enter]:");

        Scanner scan = new Scanner(System.in);                                  //Scanner opened
        int choice = 1; //scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1 was chosen");
                new PopularProducts().readProducts();

                break;
            case 2:
                System.out.println("2 was chosen");
                break;
        }

        scan.close();                                                           //Scanner closed
    }

    

}
