package Day2_100222;

public class T4_WhileLoop_LinearArray {

    public static void main(String[] args) {
        //declare and define linear array for street number
        int[] streetNumber = new int[]{111,222,333,444,555,32,3,76,5,25,37,4,7564};
        //iterate through all street number by while loop
        //set the initiator
        int i=0;
        //now set the condition for the while loop
        //linear array gets the count by using .length
        while (i < streetNumber.length) {
            System.out.println("Street number: " + streetNumber[i]);
            i++;//incrementation goes at the end of the while loop
        }//end of while loop
    }//end of main

}//end of java class

