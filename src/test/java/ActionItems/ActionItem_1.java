package ActionItems;

import java.util.ArrayList;

public class ActionItem_1 {

    public static void main(String[] args){
        //Using String country and int countryCode with for loop and ArrayList
        //declare and define a String ArrayList for countries
        ArrayList<String> country = new ArrayList<>();
        //declare and define an Integer ArrayList for country codes
        ArrayList<Integer> countryCode = new ArrayList<>();
        //add values to the countries array
        country.add("Egypt");
        country.add("Brazil");
        country.add("Canada");
        country.add("Japan");
        country.add("Germany");
        //add values to the country codes array
        countryCode.add(20);
        countryCode.add(55);
        countryCode.add(1);
        countryCode.add(81);
        countryCode.add(49);
        //call for loop to print out each country and country code
        for (int i=0; i < country.size(); i++) {
            //print out country and country code
            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));
        }//end for loop

        //Using String[] region and int[] areaCode with while loop and linear array
        //declare and define a String Linear Array for region
        String[] region = new String[]{"Cairo", "Brasilia", "Vancouver", "Tokyo", "Munich"};
        //declare and define an Integer Linear Array for area codes
        int[] areaCode = new int[]{2, 61, 604, 3, 89};
        //use a while loop to iterate through each index in the two linear arrays
        //set the initiator
        int i=0;
        int counter=0;
        //set the condition for the while loop
        while (i < region.length) {
            //print out region and area code
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);
            //incrementation goes at the end of the while loop
            i++;
            //counter++;
        }//end while loop
        /*i=i-counter;
        while (i<country.size()){
            System.out.println("My location is " + region[i] + ", " + country.get(i) + " and the phone numbers there start with " + countryCode.get(i) + "-" + areaCode[i]);
            i++;
        }*/
    }//end of main

}//end of java class
