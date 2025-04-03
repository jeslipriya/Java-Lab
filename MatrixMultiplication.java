import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)){

            System.out.println("Enter the number of rows of Matrix A");
            int rowsA = scan.nextInt();

            System.out.println("Enter the number of columns of matrix A");
            int colsA = scan.nextInt();

            System.out.println("Enter the number of rows of Matrix B");
            int rowsB = scan.nextInt();
        
            System.out.println("Enter the number of columns of Matrix B");
            int colsB = scan.nextInt();

            int[][] a = new int [rowsA] [colsA];
            int[][] b = new int [rowsB] [colsB];
            int[][] c = new int [rowsA] [colsB];

            System.out.println("Enter the elements of matrix A");
            for(int i=0; i<rowsA; i++){
                for(int j=0; j<colsA; j++){
                    a[i][j] = scan.nextInt();
                }       
            }

            System.out.println("Enter the elements of matrix B");
            for(int i=0; i<rowsB; i++){
                for(int j=0; j<colsB; j++){
                    b[i][j] = scan.nextInt();
                }
            }

            for(int i=0; i<rowsA; i++){
                for(int j=0; j<colsB; j++){
                    for(int k=0; k<colsA; k++){
                        c[i][j] = a[i][k]*b[k][j];
                    }
                }
            }

            System.out.println("the matrix multiplication is ");
            for(int i=0; i<rowsA; i++){
                for(int j=0; j<colsB; j++){
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
            
        }
    
        catch(Exception e){
            System.out.println("Please enter Numbers as input");
        }   
    }
}
