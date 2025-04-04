import java.util.Scanner;

public class StringOperation {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){

            System.out.println("Enter the first string:");
            String str1 = scan.nextLine();
            
            System.out.println("Enter the second string:");
            String str2 = scan.nextLine();

            String concatenated = str1 + " " + str2;
            System.out.println("Concatenated string\n" + concatenated);

            System.out.println("Enter a substring to search: ");
            String substr = scan.nextLine();

            if (concatenated.contains(substr)) {
                System.out.println("Substring found!");
            }

            else{System.out.println("Substring not found!");}

            System.out.println("Enter start index: ");
            int start = scan.nextInt();

            System.out.println("Enter end index: ");
            int end = scan.nextInt();

            if (start<end && start>0 && end<concatenated.length() && end>0) {   
                String extString = concatenated.substring(start,end);
                System.out.println("Extracted substring is\n" + extString);            
            }

            else{System.out.println("Invalid indices!");}

        }
    }
}
