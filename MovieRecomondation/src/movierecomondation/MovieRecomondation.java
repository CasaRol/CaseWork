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

    ArrayList<Product> products = new ArrayList<>();

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
                new MovieRecomondation().readProducts();

                break;
            case 2:
                System.out.println("2 was chosen");
                break;
        }

        scan.close();                                                           //Scanner closed
    }

    public void readProducts() {
        try (Scanner scan = new Scanner(new File("Assets/Products.txt"))) {                            //Autocloseable Scanner
            while (scan.hasNextLine()) {
                String tmpLine = scan.nextLine();
                //System.out.println(tmpLine);
                String[] part = tmpLine.split(",");
                
                for (String part1 : part) {
                    //System.out.println(part1);
                }
                //System.out.println(Arrays.toString(part));

                int id = Integer.parseInt(part[0]);
                String name = part[1];
                String year = part[2]; //String as year shouldn't be manitpulated as an int
                String[] keywords = new String[5];
                for (int i = 0; i < 5; i++) {
                    //System.out.println("part in for-loop = " + part[i+3]);
                    if (part[i + 3] == null) {
                        keywords[i] = "X";
                    } else {
                        keywords[i] = part[i + 3];
                    }
                }
                double rating = Double.parseDouble(part[8]);
                int price = Integer.parseInt(part[9]);

                Product newProduct = new Product(id, name, year, keywords, rating, price);
                products.add(newProduct);
                
                System.out.println("newProduct = " + newProduct.toString());
            }

            //System.out.println(products.get(3).toString());

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
    }

}
