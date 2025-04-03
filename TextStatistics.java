import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextStatistics {
    public static void main(String[] args) {
        String filepath = "C:/Users/jesli/OneDrive/Desktop/Java-Lab/Demo0.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            int wordCount = 0;
            int lineCount = 0;
            int charCount = 0;

            while((line = reader.readLine()) != null ){
                lineCount++;
                charCount += line.length();
                wordCount += line.split("\\s+").length;
            }

            System.out.println("Character count = " + charCount);
            System.out.println("Word count = " + wordCount);
            System.out.println("Line count = " + lineCount);
        }

        catch(IOException e){
            System.err.println(e);
        }
    }
}
