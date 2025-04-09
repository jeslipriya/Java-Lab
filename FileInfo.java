import java.util.Scanner;
import java.io.File;

public class FileInfo {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){

        System.out.println("Enter the file name");
        String fileName = scan.nextLine();

        File file = new File(fileName);

        if(file.exists()){
            System.out.println("File Exists: yes");
            System.out.println("File Can Read: " + file.canRead());
            System.out.println("File can Write: " + file.canWrite());
            System.out.println("File Type: " + (file.isDirectory() ? "Directory" : "File"));
            System.out.println("File Size: " + file.length() + " bytes");
        }

        else{System.out.println("File Exists: No");}
    }

    catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
        
    }
}
