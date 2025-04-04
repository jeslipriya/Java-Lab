import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the first String: ");
        String firstString = scan.nextLine();

        char[] firstArray = firstString.toCharArray();
        int len = firstArray.length;
        System.out.println("The length of the string is " + len);

        System.out.println("Enter a position to find a character (0 to " + (len-1) + "): ");
        int position = scan.nextInt();

        if (position>=0 && position<len) {
            char chatAtPosition = firstArray[position];
            System.out.println("The character at the position " + position + " is " + chatAtPosition);
        }

        else{System.out.println("invalid position");}

        scan.nextLine(); //clear the buffer

        System.out.println("Enter the second String: ");
        String secondString = scan.nextLine();

        String concatenated = firstString + secondString;
        System.out.println("The concatenated string is \n" + concatenated);
        
        scan.close();
    
    }
}
