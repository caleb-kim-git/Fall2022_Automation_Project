package Day2_100222;

import java.util.ArrayList;

public class T2_ArrayList {

    public static void main(String[] args){
        //declare and define  an arrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        //add values to the countries array
        countries.add("USA");
        countries.add("Japan");
        countries.add("France");
        countries.add("Brazil");
        countries.add("Iceland");
        //print usa from countries list
        System.out.println("I live in the " + countries.get(0));
        //get the count or total size of the countries list
        System.out.println("There are " + countries.size() + " countries in my array list.");
        //call and integer arrayList for streetNumber
        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(123);
        streetNumber.add(456);
        streetNumber.add(789);
        System.out.println("The third street number in " + countries.get(2) + " is " + streetNumber.get(2));

    }//end of main

}//end of java class
