package Day4_100922;

public class T1_SplitCommand {

    public static void main(String[] args) {

        //declare string variable
        String message = "My name is John";
        //extract out John from the string using split
        //call split message using String array
        String[] splitMessage = message.split(" ");
        System.out.println(splitMessage[3]);
        System.out.println(splitMessage[3].charAt(2));

        //extracting a character from a string
        String message2 = "abcdefg";
        String[] splitMessage2 = message2.split("");
        System.out.println(splitMessage2[4]);

    }//end of main

}//end of java class
