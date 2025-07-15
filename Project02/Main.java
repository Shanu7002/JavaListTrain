/*
 * Shopping list program using a Product class.
 * The user adds products (name and price), and the program shows the total cost.
 * Good for practicing classes, constructors, getters/setters, and ArrayList.
 */
package Project02;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //initialize the list
        List<Product> newProducts = new ArrayList<>();
        boolean flag = true;
        Double finalPrice = 0.0;

        //add products to the list until flag == false
        while(flag){
            //adding price and name
            System.out.print("Enter product name:");
            String name = sc.nextLine();
            System.out.print("Enter price:");
            Double price = sc.nextDouble();

            Product products = new Product(name, price);

            newProducts.add(products);

            finalPrice += products.getPrice();

            System.out.print("Do you want to add another product? (y/n)");
            sc.nextLine();
            String add = sc.nextLine();
            if(!add.equalsIgnoreCase("y")){
                break;
            }
        }
        System.out.println("\nProducts added: ");
        for(Product product : newProducts){
            System.out.println(product);
        }

        System.out.printf("Final price: $%.2f\n", finalPrice);


        sc.close();
    }
}
