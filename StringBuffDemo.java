import java.util.Scanner;                                                                       //length

public class StringBuffDemo {                                                                     //reverse            
    public static void main(String[] args) {                                                    //delete
        try (Scanner scan = new Scanner(System.in)){

            System.out.println("Enter a String: ");
            StringBuffer sb = new StringBuffer(scan.nextLine());
        
            System.out.println("The length of the string is " + sb.length());
            System.out.println("The reverse of the string is " + sb.reverse());
            System.out.println("Enter the start index to delete ");
            int start = scan.nextInt();

            System.out.println("Enter the end index to delete ");
            int end = scan.nextInt();

            if (start>=0 && end<sb.length() && start<end) {
                sb.delete(start,end);
                System.out.println("The string after deleting is " + sb);
            }

            else{System.out.println("Invalid indices");}

        }

        catch(Exception e){
            System.err.println("Please enter Strings only!");
        }
    }
}
