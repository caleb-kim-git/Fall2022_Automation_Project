package letsPractice;

public class Diagonal_Star {
    public static void DiagonalStar(int a) {
        if (a < 5) {
            System.out.println("Invalid Value");
        } else {

            //a determines the number of rows, 8 would give 8 rows
            //First and Last row must print stars
            //First and last column must print stars
            //basically create a rectangle of stars
            //Print a star if currentRow  = currentColumn
            //print a star if row a - currentRow + 1 = currentColumn
            //basically the rectangle should have diagonals

            int currentRow = 1;

            for (int i = 0; i < a; i++) {

                if (i == 0 || (i == (a - 1))) {
                    for (int j = 0; j < a; j++) {
                        System.out.print("*");
                    }
                    if (i == 0) {
                        System.out.println(" ");
                    }
                } else {
                    int currentColumn = 1;
                    for (int k = 0; k < a; k++) {
                        if (k == 0 || k == (a - 1) || (currentColumn == currentRow) || ((a - currentRow + 1) == currentColumn)) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                        currentColumn++;

                    }//end of for loop
                    System.out.println(" ");

                }
                currentRow++;

            }//end of for loop
        }

    }//end of Diagonal Star

}//end of java class
