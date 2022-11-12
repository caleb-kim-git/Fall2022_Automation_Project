package ReviewWednesday;

import java.util.ArrayList;

public class Review1012 {

    public static void main(String[] args) {

        String subjectLine = "Automation_AI05";
        //use split to result in 05
        String[] splittedLine = subjectLine.split("_");
        String newString = splittedLine[1].substring(2);
        System.out.println("The current action item is " + newString);

////this is an example of relative xpath
//        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars");
//        //this is an example of absolute xpath
//        driver.findElement(By.xpath("//div[@class = 'RNNXgb']//div//div//input")).sendKeys("cars");

    }

}
