/*
 * Simple name list program for practicing ArrayList and basic loops.
 * The user can add names to a list and see all names at the end.
 * Useful for learning Scanner and list operations.
 */
package Project01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //initialize the list
        List<String> list = new ArrayList<>();
        boolean flag = true;

        //add people to the list
        while(flag == true){
            System.out.print("Enter the name: ");
            String name = sc.nextLine();
            list.add(name);
            System.out.print("Do you want to add more people? (y/n): ");
            String answer = sc.nextLine();
            if(answer.equalsIgnoreCase("y")){
                flag = true;
            }else{
                flag = false;
            }
        }
        //Print the list of names
        for(String name : list){
            System.out.println(name);
        }

        //Search for a specific person
        System.out.print("Do you want to find a specific person? (y/n)");
        String flag1Check = sc.nextLine();
        if(flag1Check.equalsIgnoreCase("y")){
            System.out.print("Write the person name:" );
            String name = sc.nextLine();
            Integer nameSearch = findNameIndex(list,name);
            if(nameSearch == null){
                System.out.println("This person does not exist");
            } else{
                System.out.println("This person is number " + (nameSearch + 1) + " in the list!");
            }
        }

        sc.close();
    }
    //Method to return the position of a person in the list
    public static Integer findNameIndex(List<String> list, String name){
        for(int i = 0;i < list.size();i++){
            if(list.get(i).equals(name)){
                return i;
            }
        }
        return null;
    }
}
