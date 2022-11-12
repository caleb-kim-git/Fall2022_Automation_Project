package Day3_100822;

import java.util.ArrayList;

public class T3_ArrayList_Loop_Conditions {

    public static void main(String[] args) {
        //<> refers to anchor
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Japan");
        countries.add("Germany");
        countries.add("Egypt");
        countries.add("Chile");

        //using for loop to iterate through countries list and print out only the country that is USA or Chile
        for (int i=0; i < countries.size(); i++){
            //two equals == will compare values from left and right side
            //one equal sets a value for a variable
            if (countries.get(i) == "USA"){
                System.out.println("Country is USA");
            } else if (countries.get(i) == "Chile") {
                System.out.println("Country is Chile");
            }

            //to comment a block of code, highlight the code you want to block, and do ctrl + / or ctrl + shift + /. shift will make it /**/, no shift will do //
            //using or operator || you can write both/multiple conditions on one if statement
            /*if (countries.get(i) == "USA" || countries.get(i) == "Chile"){
                System.out.println("Country is " + countries.get(i));
            }*/
        }



    }//end of main

}//end of java class
