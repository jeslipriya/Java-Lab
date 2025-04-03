import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter the lower limit: ");
        int lowerLimit = scan.nextInt();
    
        System.out.print("Enter the upper limit: ");
        int upperLimit = scan.nextInt();
    
        int randomNumber = random.nextInt(upperLimit-lowerLimit+1) + lowerLimit;
        System.out.println("Generated random number is " + randomNumber);
        
        if(randomNumber < 0) {
            System.out.println("The number is below Zero");
        }

        else if (randomNumber> 0 && randomNumber <= 10) {   
            System.out.println("The number is between 0 and 10");
        }
        else if (randomNumber> 10 && randomNumber <= 20) {   
            System.out.println("The number is between 10 and 20");
        }
        else if (randomNumber> 20 && randomNumber <= 50) {   
            System.out.println("The number is between 20 and 50");
        }
        else {   
            System.out.println("The number is above 50");
        }

        scan.close();
    }
}
