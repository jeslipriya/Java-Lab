import java.util.Scanner;

class PrimeNumber{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("enter a number");
        int n = scan.nextInt();

        System.out.println("The prime numbers are");

        for(int i=2; i<=n; i++){
            boolean isPrime = true;
            for(int j=2; j*j<=i; j++){
                if (i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                System.out.print(i+ " ");
            }
        }

        scan.close();
    }
}