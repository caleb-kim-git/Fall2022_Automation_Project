package Day2_100222;

import java.util.ArrayList;

public class T3_ForLoop_ArrayList {

    public static void main(String[] args) {
        //declare and define array list for zip codes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11111");
        zipCode.add("22222");
        zipCode.add("33333");
        zipCode.add("44444");
        zipCode.add("55555");
        zipCode.add("55555");
        zipCode.add("66666");
        zipCode.add("77777");

        //call for loop to print all the zip code values from the array list
        for (int i=0, j=1; i < zipCode.size(); i++,j++) {
            //print out each zipcode automatically
            System.out.println("Zipcode #" + j + ": " + zipCode.get(i));
        };//end for loop
    }//end of main

}//end of class

