package ReviewWednesday;

import java.util.ArrayList;

public class Review1005 {

    public static void main(String[] args) {

        String[] cars = new String[]{"BMW", "Audi", "Cadillac", "Ford", "Volkswagen"};
        int i=0;
        while (i < cars.length) {
            System.out.println("Car brand: " +cars[i]);
            i++;
        }

        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("2645867302");
        phoneNumbers.add("1927830500");
        phoneNumbers.add("8862737402");
        phoneNumbers.add("1402938757");
        phoneNumbers.add("2383712938");

        for (i=0; i<phoneNumbers.size();i++){
            System.out.println("Phone number: " + phoneNumbers.get(i));
        }

    }

}
