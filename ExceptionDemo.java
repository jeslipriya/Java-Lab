import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)){

        //Arithmetic exception
        try {
            System.out.println("Divide 10 by");
            int num = scan.nextInt();
            System.out.println("The result: " + 10/num);
        } catch (ArithmeticException e) {
            System.out.println("Number cannot be divided by 0!");
        }

        //Number Format exception
        try{
            System.out.println("Enter a number");
            int parsedNumber = Integer.parseInt(scan.next());
            System.out.println("Parsed Int = " + parsedNumber);
        } catch(NumberFormatException e){
            System.out.println("Invalid Number format!");
        }

        //array index out of bound exception
        try {
            int[] array = {1,2,3};
            System.out.println("Accessable index 0-2: ");
            int access = scan.nextInt();
            System.out.println("Array value: " + array[access]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index!");
        }

        //NegativeArray size exception

        try {
            System.out.println("enter the array size");
            int size = scan.nextInt();
            int[] arr = new int[size];
            System.out.println("Array created int the size: " + size);
        } catch (NegativeArraySizeException e) {
            System.out.println("Array size cannot be negative!");
        }
    }

    catch(Exception e){
        System.out.println(e);
    }
    }
}
